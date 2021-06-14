package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category", uniqueConstraints = { //
        @UniqueConstraint(name = "CATEGORY_UK", columnNames = "code")})
public class CategoryEntity extends BaseEntity {

    //column
    @Column
    private String code;
    @Column
    private String name;
    @OneToMany(mappedBy = "category")
    private List<BookEntity> bookList = new ArrayList<>();
    //getter,setter


    public List<BookEntity> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookEntity> bookList) {
        this.bookList = bookList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
