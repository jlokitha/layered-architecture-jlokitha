package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailDAO {
    boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException;
}
