package com.cdweb.service;

import com.cdweb.dto.BookDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService extends  IGeneralService<BookDTO>{
    public int totalItem() ;
    List<BookDTO> findAll(Pageable pageable);
}
