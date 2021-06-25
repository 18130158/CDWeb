package com.cdweb.service;

import com.cdweb.dto.OrderedDTO;

import java.util.List;

public interface IOrderedService {
    public OrderedDTO save(OrderedDTO orderedDTO);
    public List<OrderedDTO> findAllOrder(String email);
}
