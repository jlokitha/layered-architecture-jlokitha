package lk.jl.layeredarchitecture.dto;

public class CustomerOrderDetailsDTO {
    private String orderId;
    private String total;
    private String date;
    private String id;
    private String name;
    private String address;

    public CustomerOrderDetailsDTO() {
    }

    public CustomerOrderDetailsDTO(String orderId, String total, String date, String id, String name, String address) {
        this.orderId = orderId;
        this.total = total;
        this.date = date;
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CustomerOrderDetailsDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", orderId='" + orderId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
