package lk.jl.layeredarchitecture.bo.custom.impl;

import lk.jl.layeredarchitecture.bo.custom.CustomerBO;
import lk.jl.layeredarchitecture.dao.DAOFactory;
import lk.jl.layeredarchitecture.dao.custom.CustomerDAO;
import lk.jl.layeredarchitecture.dto.CustomerDTO;
import lk.jl.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.CUSTOMER );
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
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save( new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress()
        ) );
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update( new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress()
        ) );
    }
    @Override
    public boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExists( id );
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete( id );
    }
    @Override
    public String generateNewCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewId();
    }
}
