package com.example.layeredarchitecture.util;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtil {
    Connection connection = DBConnection.getDbConnection().getConnection();

    public TransactionUtil() throws SQLException, ClassNotFoundException {
    }

    public void startTransaction() throws SQLException {
        System.out.println("start");
        connection.setAutoCommit(false);
    }

    public void endTransaction() throws SQLException {
        System.out.println("end");
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void rollBack() throws SQLException {
        System.out.println("rollback");
        connection.rollback();
        connection.setAutoCommit(true);
    }
}
