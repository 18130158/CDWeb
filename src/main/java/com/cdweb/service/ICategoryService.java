package com.cdweb.service;

import com.cdweb.dto.BookDTO;
import com.cdweb.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService{
    List<CategoryDTO> findAll();

    CategoryDTO save(CategoryDTO categoryDTO);
}
