package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_UK", columnNames = "user_name")})
public class UserEntity extends BaseEntity {
    //column
    @Column(name = "user_name")
    private String userName;
    @Column
    private String password;
    @Column
    private String fullName;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private int status;
    //map

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roleList = new ArrayList<>();


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }
}
