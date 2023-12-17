package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        if (rst.next()) return rst.getString(1);

        return null;
    }

    @Override
    public boolean isExists(String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);

        return stm.executeQuery() != null;
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();

        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, dto.getOrderId());
        stm.setDate(2, Date.valueOf(dto.getOrderDate()));
        stm.setString(3, dto.getCustomerId());

        return stm.executeUpdate() > 0;
    }
}
