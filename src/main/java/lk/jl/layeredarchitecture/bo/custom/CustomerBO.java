package lk.jl.layeredarchitecture.bo.custom;

import lk.jl.layeredarchitecture.bo.SuperBO;
import lk.jl.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateNewCustomerId() throws SQLException, ClassNotFoundException;
}
