package lk.jl.layeredarchitecture.bo.custom.impl;

import lk.jl.layeredarchitecture.bo.custom.ItemBO;
import lk.jl.layeredarchitecture.dao.DAOFactory;
import lk.jl.layeredarchitecture.dao.custom.ItemDAO;
import lk.jl.layeredarchitecture.dto.ItemDTO;
import lk.jl.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.ITEM );
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> items = new ArrayList<>();

        for (Item item : itemDAO.getAll()) {
            items.add( new ItemDTO(
                    item.getCode(),
                    item.getDescription(),
                    item.getQtyOnHand(),
                    item.getUnitPrice()
            ) );
        }
        return items;
    }
    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete( id );
    }
    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save( new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getQtyOnHand(),
                dto.getUnitPrice()
        ) );
    }
    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update( new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getQtyOnHand(),
                dto.getUnitPrice()
        ) );
    }
    @Override
    public String generateNewItemId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }
    @Override
    public boolean isExistsItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.isExists( id );
    }
}
