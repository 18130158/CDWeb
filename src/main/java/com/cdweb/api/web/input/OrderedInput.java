package com.cdweb.api.web.input;

import java.util.ArrayList;
import java.util.List;

public class OrderedInput {
    private List<Long> carts = new ArrayList<>();

    public List<Long> getCarts() {
        return carts;
    }

    public void setCarts(List<Long> carts) {
        this.carts = carts;
    }
}
