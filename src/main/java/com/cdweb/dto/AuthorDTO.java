package com.cdweb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorDTO extends AbstractDTO<AuthorDTO>{
    private String name;
    private Date birthday;
    private String information;
    public AuthorDTO() {
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
