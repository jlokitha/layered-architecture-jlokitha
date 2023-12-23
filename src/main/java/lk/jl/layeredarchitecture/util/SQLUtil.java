package lk.jl.layeredarchitecture.util;

import lk.jl.layeredarchitecture.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String sql, Object... arg) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DBConnection.getDbConnection().getConnection().prepareStatement(sql);

        for (int i = 0; i < arg.length; i++) {
            statement.setObject((i + 1), arg[i]);
        }

        if (sql.trim().toUpperCase().startsWith("SELECT")){
            return (T) statement.executeQuery();
        }else {
            return(T)(Boolean)(statement.executeUpdate() > 0);
        }
    }
}
