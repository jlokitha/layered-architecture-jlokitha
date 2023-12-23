package lk.jl.layeredarchitecture.bo.custom;

import lk.jl.layeredarchitecture.bo.SuperBO;
import lk.jl.layeredarchitecture.dto.CustomerDTO;
import lk.jl.layeredarchitecture.dto.ItemDTO;
import lk.jl.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {
    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean isExistsItem(String id) throws SQLException, ClassNotFoundException;
    boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException;
    String generateNewOrderId() throws SQLException, ClassNotFoundException;
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
}
