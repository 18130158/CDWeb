package com.cdweb.service;

import com.cdweb.dto.BookDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService extends IGeneralService<BookDTO> {

    public List<BookDTO> findAll(Pageable pageable);

    public List<BookDTO> findByCategory(Long category_id, Pageable pageable);


    public BookDTO findById(Long id);

    public List<BookDTO> findByHot(Pageable pageable);

    public List<BookDTO> findByNew(Pageable pageable);

    public List<BookDTO> findByDiscount(Pageable pageable);


    public int countByCategory(Long category);

    public int countByHot();

    public int countByNew();

    public int countAll();

    public int countByDiscount();
}
