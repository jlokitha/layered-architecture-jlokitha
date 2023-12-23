package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.MainBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.model.CustomerOrderDetailsDTO;
import javafx.fxml.FXML;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainBOImpl implements MainBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.QUERY );

    @Override
    public ArrayList<CustomerOrderDetailsDTO> customerOrderDetails() throws SQLException, ClassNotFoundException {
        return queryDAO.customerOrderDetails();
    }
}
