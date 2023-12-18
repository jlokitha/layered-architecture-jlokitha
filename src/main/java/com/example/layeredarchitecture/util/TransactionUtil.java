package com.example.layeredarchitecture.util;

import java.sql.SQLException;

public interface TransactionUtil {
    void startTransaction() throws SQLException;

    void endTransaction() throws SQLException;

    void rollBack() throws SQLException;
}
