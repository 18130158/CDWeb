package com.cdweb.dto;

public class RoleDTO extends AbstractDTO<RoleDTO> {
    private String name;

    public RoleDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
