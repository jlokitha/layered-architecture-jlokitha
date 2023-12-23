package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.entity.OrderDetails;
import com.example.layeredarchitecture.util.CrudUtil;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudUtil<OrderDetails> {
    boolean saveOrderDetail(OrderDetails entity) throws SQLException, ClassNotFoundException;
}
