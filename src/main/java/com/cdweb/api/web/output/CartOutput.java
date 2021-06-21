package com.cdweb.api.web.output;

import com.cdweb.dto.ShoppingCartDTO;

import java.util.ArrayList;
import java.util.List;

public class CartOutput {
    private double total;
    private List<ShoppingCartDTO> list=new ArrayList<>();

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ShoppingCartDTO> getList() {
        return list;
    }

    public void setList(List<ShoppingCartDTO> list) {
        this.list = list;
    }
}
