package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `orders` ORDER BY oid DESC LIMIT 1;");

        if (rst.next()) return rst.getString(1);

        return null;
    }

    @Override
    public boolean isExists(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `orders` WHERE oid=?", orderId);

        return rst.next();
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `orders` (oid, date, customerID) VALUES (?,?,?)",
                dto.getOrderId(),
                dto.getOrderDate(),
                dto.getCustomerId());
    }
}
