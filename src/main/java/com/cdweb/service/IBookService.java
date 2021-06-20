package com.cdweb.service;

import com.cdweb.dto.BookDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService extends IGeneralService<BookDTO> {

    public List<BookDTO> findAll(Pageable pageable);

    public List<BookDTO> findByCategory(String category_code, Pageable pageable);


    public BookDTO findById(Long id);

    public List<BookDTO> findByHot(Pageable pageable);

    public List<BookDTO> findByNew(Pageable pageable);

    public List<BookDTO> findByDiscount(Pageable pageable);


    public int countByCategory(String category);

    public int countByHot();

    public int countByNew();

    public int countAll();

    public int countByDiscount();

    List<BookDTO> findByTitle(String title, Pageable pageable);

    int countByTitle(String title);

    List<String> autoCompleteTitle(String title);
}
