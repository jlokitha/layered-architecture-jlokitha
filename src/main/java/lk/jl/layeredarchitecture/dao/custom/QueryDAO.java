package lk.jl.layeredarchitecture.dao.custom;

import lk.jl.layeredarchitecture.dao.SuperDAO;
import lk.jl.layeredarchitecture.dto.CustomerOrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomerOrderDetailsDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
