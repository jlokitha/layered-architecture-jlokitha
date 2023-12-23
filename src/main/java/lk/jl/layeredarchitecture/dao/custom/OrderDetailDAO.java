package lk.jl.layeredarchitecture.dao.custom;

import lk.jl.layeredarchitecture.entity.OrderDetails;
import lk.jl.layeredarchitecture.util.CrudUtil;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudUtil<OrderDetails> {
    boolean saveOrderDetail(OrderDetails entity) throws SQLException, ClassNotFoundException;
}
