package com.cdweb.service;



import java.util.List;

public interface IGeneralService<T> {
    public List<T> findAll();
    public T save(T t);
    public T update(T t);
    public void delete(long[] ids);
}
