package com.cdweb.dto;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderedDTO {
    private Long id;
    private UserDTO user;
    private String status;
    private String orderedDate;
    private Date receiveDate;
    private double totalPrice;
    private List<OrderedItemDTO> orderedItemList = new ArrayList<>();

    public OrderedDTO() {

    }

    public void setNowDate(){
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND)
                + " " + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH + 1) + "/" + calendar.get(Calendar.YEAR);
        this.orderedDate = date;
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

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
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
