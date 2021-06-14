package com.cdweb.service;

import com.cdweb.dto.BookDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService extends IGeneralService<BookDTO> {

    public List<BookDTO> findAll(Pageable pageable);

    public List<BookDTO> findByCategory(String code, int limit, int offset, String sort, String order);

    public long countByCategory(String category);
    public BookDTO findById(Long id);

    public List<BookDTO> findByHot(Pageable pageable);
    public List<BookDTO> findByNew(Pageable pageable);
    public List<BookDTO> findByDiscount(Pageable pageable);
}
