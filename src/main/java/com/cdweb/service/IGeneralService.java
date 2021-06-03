package com.cdweb.service;


import org.springframework.stereotype.Service;

import java.util.List;

public interface IGeneralService<T> {
    public List<T> findAll();
    public T save(T t);
    public T update(T t);
    public T deleta(long[] ids);
}
