package lk.jl.layeredarchitecture.dao.custom.impl;

import lk.jl.layeredarchitecture.dao.custom.ItemDAO;
import lk.jl.layeredarchitecture.entity.Item;
import lk.jl.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");

        ArrayList<Item> allItems = new ArrayList<>();

        while (rst.next()) {
            Item item = new Item(
                    rst.getString( 1 ),
                    rst.getString( 2 ),
                    rst.getInt( 3 ),
                    rst.getBigDecimal( 4 )
            );
            allItems.add( item );
        }

        return allItems;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE code=?", id);
    }

    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description,qtyOnHand,unitPrice) VALUES (?,?,?,?)",
                entity.getCode(),
                entity.getDescription(),
                entity.getQtyOnHand(),
                entity.getUnitPrice());
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getQtyOnHand(),
                entity.getCode());
    }

    @Override
    public boolean isExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?", id);

        return rst.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        if (rst.next()) {
            return rst.getString( 1 );
        }

        return null;
    }

    @Override
    public Item search(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?", (newItemCode + ""));

        if (rst.next()) {
            return new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getBigDecimal(4)
            );
        }

        return null;
    }
}
