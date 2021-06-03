package com.cdweb.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity {
    //column
    @Column
    private String name;
    @Column
    private Date birthday;
    @Column
    private String information;

    @ManyToMany(mappedBy = "authorList")
    private List<BookEntity> bookList=new ArrayList<>();

    public List<BookEntity> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookEntity> bookList) {
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
