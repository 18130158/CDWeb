package com.cdweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_state")
public class UserStateEntity extends BaseEntity {
    //column
    @Column
    private String state;
    //map
    @OneToMany(mappedBy = "userState")
    private List<UserEntity> userList = new ArrayList<>();

    //getter,setter
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<UserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity> userList) {
        this.userList = userList;
    }
}
