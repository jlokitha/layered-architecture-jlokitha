package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();

        String sql = "INSERT INTO orderdetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, orderId);
        stm.setString(2, detailDTO.getItemCode());
        stm.setBigDecimal(3, detailDTO.getUnitPrice());
        stm.setInt(4, detailDTO.getQty());

        return stm.executeUpdate() > 0;
    }
}
