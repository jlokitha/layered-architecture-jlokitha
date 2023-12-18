package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.CustomerOrderDetailsDTO;

import java.sql.SQLException;

public interface QueryDAO {
    void customerOrderDetails(CustomerOrderDetailsDTO dto) throws SQLException, ClassNotFoundException;
}
