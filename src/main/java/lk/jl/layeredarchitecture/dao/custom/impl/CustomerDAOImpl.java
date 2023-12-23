package lk.jl.layeredarchitecture.dao.custom.impl;

import lk.jl.layeredarchitecture.dao.custom.CustomerDAO;
import lk.jl.layeredarchitecture.entity.Customer;
import lk.jl.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<Customer> allCustomers = new ArrayList<>();

        while (rst.next()) {

            Customer entity = new Customer(
                    rst.getString( 1 ),
                    rst.getString( 2 ),
                    rst.getString( 3 ) );

            allCustomers.add( entity );
        }

        return allCustomers;
    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO Customer VALUES (?,?,?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress());
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",
                entity.getName(),
                entity.getAddress(),
                entity.getId());
    }

    @Override
    public boolean isExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);

        return rst.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            return rst.getString( 1 );
        }

        return null;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", (id + ""));

        if (rst.next()) {
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }

        return null;
    }
}
