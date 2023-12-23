package lk.jl.layeredarchitecture.dao.custom.impl;

import lk.jl.layeredarchitecture.dao.custom.OrderDetailDAO;
import lk.jl.layeredarchitecture.entity.OrderDetails;
import lk.jl.layeredarchitecture.util.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean saveOrderDetail(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                entity.getOid(),
                entity.getItemCode(),
                entity.getUnitPrice(),
                entity.getQty());
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean isExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetails search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
