package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.CustomerOrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MainBO extends SuperBO {
    ArrayList<CustomerOrderDetailsDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
