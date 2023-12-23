package lk.jl.layeredarchitecture.util;

import lk.jl.layeredarchitecture.dao.SuperDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudUtil<T> extends SuperDAO {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean isExists(String id) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    T search(String id) throws SQLException, ClassNotFoundException;
}
