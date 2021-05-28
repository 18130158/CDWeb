package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    //column
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String fullName;
    @Column
    private String email;
    @Column
    private String address;
    //map

    @OneToMany(mappedBy = "user")
    private List<OrderedEntity> orderedList = new ArrayList<>();

    @ManyToMany(mappedBy = "userList")
    private List<RoleEntity> roleList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<BookEntity> bookList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_state_id")
    private UserStateEntity userState;


    @OneToMany(mappedBy = "user")
    private List<CommentEntity> commentList = new ArrayList<>();

    //getter,setter
    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderedEntity> getOrderedList() {
        return orderedList;
    }

    public void setOrderedList(List<OrderedEntity> orderedList) {
        this.orderedList = orderedList;
    }

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }

    public UserStateEntity getUserState() {
        return userState;
    }

    public void setUserState(UserStateEntity userState) {
        this.userState = userState;
    }

    public List<BookEntity> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookEntity> bookList) {
        this.bookList = bookList;
    }
}
