package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PlaceOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.OrdersDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.entity.Item;
import com.example.layeredarchitecture.entity.OrderDetails;
import com.example.layeredarchitecture.entity.Orders;
import com.example.layeredarchitecture.util.TransactionUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.ORDER );
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.ORDER_DETAIL );
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.ITEM );
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.CUSTOMER );

    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {

            TransactionUtil.startTransaction();

            boolean isExists = ordersDAO.isExists(orderId);
            /*if order id already exist*/
            if (isExists) {

            }

            boolean isSaved = ordersDAO.save(new Orders(orderId, orderDate, customerId));

            if (!isSaved) {
                TransactionUtil.rollBack();
                return false;
            }

            for (OrderDetailDTO detail : orderDetails) {

                if (!orderDetailDAO.saveOrderDetail(new OrderDetails(orderId,detail.getItemCode(),detail.getQty(),detail.getUnitPrice()) )) {
                    TransactionUtil.rollBack();
                    return false;
                }

//                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                if (!itemDAO.update(new Item(item.getCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice()) )) {
                    TransactionUtil.rollBack();
                    return false;
                }
            }

            TransactionUtil.endTransaction();
            return true;
    }

    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        Item search = itemDAO.search( newItemCode );

        return new ItemDTO(
                search.getCode(),
                search.getDescription(),
                search.getQtyOnHand(),
                search.getUnitPrice()
        );
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer entity = customerDAO.search( id );

        return new CustomerDTO(
               entity.getId(),
               entity.getName(),
               entity.getAddress()
        );
    }

    @Override
    public boolean isExistsItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.isExists( id );
    }

    @Override
    public boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExists( id );
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return ordersDAO.generateNewId();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> customers = new ArrayList<>();

        for (Customer customer : customerDAO.getAll()) {
            customers.add( new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress()
            ) );
        }
        return customers;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> items = new ArrayList<>();

        for (Item item : itemDAO.getAll()) {
            items.add( new ItemDTO(
                    item.getCode(),
                    item.getDescription(),
                    item.getQtyOnHand(),
                    item.getUnitPrice()
            ) );
        }
        return items;
    }

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        Item search = itemDAO.search( code );
        return new ItemDTO(
                search.getCode(),
                search.getDescription(),
                search.getQtyOnHand(),
                search.getUnitPrice()
        );
    }
}
