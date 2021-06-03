package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordered")
public class OrderedEntity extends BaseEntity {
    //column
    @Column(name = "ordered_date")
    private Date orderDate;
    @Column(name = "received_date")
    private Date receiveDate;
    @Column
    private Long totalPrice;
    @Column
    private int status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


