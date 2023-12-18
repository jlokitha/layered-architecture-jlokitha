package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrdersDAO {
    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean isExists(String orderId) throws SQLException, ClassNotFoundException;

    boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
