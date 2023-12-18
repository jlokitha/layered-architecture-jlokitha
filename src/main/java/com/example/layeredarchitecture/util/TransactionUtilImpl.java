package com.example.layeredarchitecture.util;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtilImpl implements TransactionUtil {
    Connection connection = DBConnection.getDbConnection().getConnection();

    public TransactionUtilImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    @Override
    public void endTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    @Override
    public void rollBack() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }
}
