package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.OrdersDAO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                dto.getOrderId(),
                dto.getOrderDate(),
                dto.getCustomerId());
    }

    @Override
    public boolean isExists(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?", orderId);

        return rst.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        if (rst.next()) return rst.getString(1);

        return null;
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
