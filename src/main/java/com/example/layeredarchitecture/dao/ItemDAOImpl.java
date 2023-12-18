package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item");

        ArrayList<ItemDTO> allItems = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString( 1 ),
                    rst.getString( 2 ),
                    rst.getInt( 3 ),
                    rst.getBigDecimal( 4 )
            );
            allItems.add( itemDTO );
        }

        return allItems;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM item WHERE code=?", id);
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                dto.getCode(),
                dto.getDescription(),
                dto.getQtyOnHand(),
                dto.getUnitPrice());
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand(),
                dto.getCode());
    }

    @Override
    public boolean isExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM item WHERE code=?", id);

        return rst.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT code FROM item ORDER BY code DESC LIMIT 1;");

        if (rst.next()) {
            return rst.getString( 1 );
        }

        return null;
    }

    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item WHERE code=?", (newItemCode + ""));

        if (rst.next()) {
            return new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getBigDecimal(4)
            );
        }

        return null;
    }
}
