package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordered")
public class OrderedEntity extends BaseEntity{
    //column
    @Column(name = "ordered_date")
    private Date orderDate;
    @Column(name = "received_date")
    private Date receiveDate;
    @Column
    private Long totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "ordered_state_id")
    private OrderedStateEntity orderedState;

    @OneToMany(mappedBy = "ordered")
    private List<OrderedItemEntity> orderedItemList = new ArrayList<>();

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

    public OrderedStateEntity getOrderedState() {
        return orderedState;
    }

    public void setOrderedState(OrderedStateEntity orderedState) {
        this.orderedState = orderedState;
    }

    public List<OrderedItemEntity> getOrderedItemList() {
        return orderedItemList;
    }

    public void setOrderedItemList(List<OrderedItemEntity> orderedItemList) {
        this.orderedItemList = orderedItemList;
    }
}


