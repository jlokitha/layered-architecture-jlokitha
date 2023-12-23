package lk.jl.layeredarchitecture.dao.custom.impl;

import lk.jl.layeredarchitecture.dao.custom.OrdersDAO;
import lk.jl.layeredarchitecture.entity.Orders;
import lk.jl.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public boolean save(Orders entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                entity.getOid(),
                entity.getDate(),
                entity.getCustomerID()
        );
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
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Orders entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Orders search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
