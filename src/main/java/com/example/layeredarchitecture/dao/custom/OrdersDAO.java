package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.entity.Orders;
import com.example.layeredarchitecture.util.CrudUtil;

import java.sql.*;

public interface OrdersDAO extends CrudUtil<Orders> {
    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean isExists(String orderId) throws SQLException, ClassNotFoundException;
}
