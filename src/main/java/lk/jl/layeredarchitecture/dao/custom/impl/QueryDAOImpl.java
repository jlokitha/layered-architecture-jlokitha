package lk.jl.layeredarchitecture.dao.custom.impl;

import lk.jl.layeredarchitecture.dao.custom.QueryDAO;
import lk.jl.layeredarchitecture.dto.CustomerOrderDetailsDTO;
import lk.jl.layeredarchitecture.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomerOrderDetailsDTO> customerOrderDetails() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT o.oid, SUM(od.unitPrice * od.qty), o.date, c.id , c.name, c.address " +
                "FROM Customer c " +
                "RIGHT JOIN Orders o " +
                "ON o.customerID = c.id " +
                "LEFT JOIN OrderDetails od " +
                "ON o.oid = od.oid " +
                "GROUP BY o.oid, o.date, c.id, c.name, c.address " +
                "ORDER BY o.oid;");

        ArrayList<CustomerOrderDetailsDTO> list = new ArrayList<>();

        while (rst.next()) {
            CustomerOrderDetailsDTO custom = new CustomerOrderDetailsDTO(
                    rst.getString( 1 ),
                    rst.getString( 2 ),
                    rst.getString( 3 ),
                    rst.getString( 4 ),
                    rst.getString( 5 ),
                    rst.getString( 6 )
            );

            list.add( custom );
        }
        return list;
    }
}
