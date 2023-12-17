package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.SqlUtil;

import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO orderdetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderId,
                detailDTO.getItemCode(),
                detailDTO.getUnitPrice(),
                detailDTO.getQty());
    }
}
