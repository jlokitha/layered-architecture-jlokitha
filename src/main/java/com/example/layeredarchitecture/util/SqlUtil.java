package com.example.layeredarchitecture.util;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtil {
    public static <T> T execute(String sql, Object... arg) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDbConnection().getConnection().prepareStatement(sql);

        for (int i = 0; i < arg.length; i++) {
            statement.setObject((i + 1), arg[i]);
        }

        System.out.println(statement.toString());
        if (sql.trim().toUpperCase().startsWith("SELECT")){
            return (T) statement.executeQuery();
        }else {
            return(T)(Boolean)(statement.executeUpdate()>0);
        }
    }

    /*public static <T> T execute(String sql, Object... arg) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDbConnection().getConnection().prepareStatement(sql);

        if (arg != null) {
            for (int i = 0; i < arg.length; i++) {
                if (arg[i] instanceof Integer) {
                    statement.setInt(i + 1, (int) arg[i]);
                } else if (arg[i] instanceof String) {
                    statement.setString(i + 1, (String) arg[i]);
                } else if (arg[i] instanceof Double) {
                    statement.setDouble(i + 1, (double) arg[i]);
                }else if (arg[i] instanceof BigDecimal) {
                    statement.setObject(i + 1, arg[i]);
                }
            }
        }
        System.out.println(statement.toString());
        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) statement.executeQuery();
        }else {
            return(T)(Boolean)(statement.executeUpdate()>0);
        }
    }*/
}
