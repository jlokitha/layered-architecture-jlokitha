package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrdersDAO {
    String generateNextOrderId() throws SQLException, ClassNotFoundException;

    boolean isExists(String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
