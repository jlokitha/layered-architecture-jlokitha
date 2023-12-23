package lk.jl.layeredarchitecture.bo.custom.impl;

import lk.jl.layeredarchitecture.bo.custom.MainBO;
import lk.jl.layeredarchitecture.dao.DAOFactory;
import lk.jl.layeredarchitecture.dao.custom.QueryDAO;
import lk.jl.layeredarchitecture.dto.CustomerOrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainBOImpl implements MainBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO( DAOFactory.DAOType.QUERY );

    @Override
    public ArrayList<CustomerOrderDetailsDTO> customerOrderDetails() throws SQLException, ClassNotFoundException {
        return queryDAO.customerOrderDetails();
    }
}
