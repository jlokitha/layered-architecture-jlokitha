package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO orderdetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderId,
                detailDTO.getItemCode(),
                detailDTO.getUnitPrice(),
                detailDTO.getQty());
    }
}
