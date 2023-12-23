package lk.jl.layeredarchitecture.dao.custom;

import lk.jl.layeredarchitecture.entity.Orders;
import lk.jl.layeredarchitecture.util.CrudUtil;

import java.sql.*;

public interface OrdersDAO extends CrudUtil<Orders> {
    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean isExists(String orderId) throws SQLException, ClassNotFoundException;
}
