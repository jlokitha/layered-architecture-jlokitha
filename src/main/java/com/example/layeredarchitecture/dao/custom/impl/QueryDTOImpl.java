package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomerOrderDetailsDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDTOImpl implements QueryDAO {
    @Override
    public void customerOrderDetails(CustomerOrderDetailsDTO dto) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("");
    }
}
