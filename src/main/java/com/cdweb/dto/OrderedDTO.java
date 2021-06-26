package com.cdweb.dto;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderedDTO {
    private Long id;
    private UserDTO user;
    private String status;
    private Date orderedDate;
    private Date receiveDate;
    private double totalPrice;
    private String name;
    private String phone;
    private String address;
    private List<OrderedItemDTO> orderedItemList = new ArrayList<>();

    public OrderedDTO() {

    }

    public void setNowDate() {
        Calendar calendar = Calendar.getInstance();
        this.orderedDate = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderedItemDTO> getOrderedItemList() {
        return orderedItemList;
    }

    public void setOrderedItemList(List<OrderedItemDTO> orderedItemList) {
        this.orderedItemList = orderedItemList;
    }
}
