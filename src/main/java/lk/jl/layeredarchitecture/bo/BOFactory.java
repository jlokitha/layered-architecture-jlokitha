package lk.jl.layeredarchitecture.bo;

import lk.jl.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import lk.jl.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import lk.jl.layeredarchitecture.bo.custom.impl.MainBOImpl;
import lk.jl.layeredarchitecture.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType {
        CUSTOMER,ITEM,PLACE_ORDER,MAIN
    }

    public SuperBO getBO(BOType boType) {
        switch (boType) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            case MAIN:
                return new MainBOImpl();
            default:
                return null;
        }
    }
}
