package com.cdweb.service;

import java.security.Principal;

public interface IOrderItemService {
    public int addProduct(long id, Principal principal);
}
