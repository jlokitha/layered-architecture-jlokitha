package lk.jl.layeredarchitecture.bo.custom;

import lk.jl.layeredarchitecture.bo.SuperBO;
import lk.jl.layeredarchitecture.dto.CustomerOrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MainBO extends SuperBO {
    ArrayList<CustomerOrderDetailsDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
