package com.example.layeredarchitecture.model;

public class CustomerOrderDetailsDTO {
    private String id;
    private String name;
    private String address;
    private String orderId;
    private String date;

    public CustomerOrderDetailsDTO() {
    }

    public CustomerOrderDetailsDTO(String id, String name, String address, String orderId, String date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orderId = orderId;
        this.date = date;
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
