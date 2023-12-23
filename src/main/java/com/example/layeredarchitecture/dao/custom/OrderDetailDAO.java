package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.CrudUtil;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudUtil<OrderDetailDTO> {
    boolean saveOrderDetail(String orderId, OrderDetailDTO detailDTO) throws SQLException, ClassNotFoundException;
}
