package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "active")
public class ActiveEntity extends BaseEntity {
    //column
    @Column
    private String status;

    //map
    @OneToMany(mappedBy = "active")
    private List<BookEntity> bookList = new ArrayList<>();

    //getter,setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BookEntity> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookEntity> bookList) {
        this.bookList = bookList;
    }
}
