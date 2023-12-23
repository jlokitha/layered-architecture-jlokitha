package lk.jl.layeredarchitecture.bo.custom;

import lk.jl.layeredarchitecture.bo.SuperBO;
import lk.jl.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    String generateNewItemId() throws SQLException, ClassNotFoundException;

    boolean isExistsItem(String id) throws SQLException, ClassNotFoundException;
}
