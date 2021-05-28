package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catergory")
public class CatergoryEntity extends BaseEntity {

    //column
    @Column
    private String code;
    @Column
    private String name;
    //map
    @ManyToMany
    @JoinTable(name = "catergory_book",
            joinColumns = @JoinColumn(name = "catergory_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
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
