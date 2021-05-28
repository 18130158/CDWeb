package com.cdweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordered_state")
public class OrderedStateEntity extends BaseEntity {
    //column
    @Column
    private String name;
    //map

    @OneToMany(mappedBy = "orderedState")
    private List<OrderedEntity> orderedList = new ArrayList<>();

    //getter,setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderedEntity> getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(List<OrderedEntity> orderList) {
        this.orderedList = orderList;
    }
}
