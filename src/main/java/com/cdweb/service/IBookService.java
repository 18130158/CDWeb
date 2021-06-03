package com.cdweb.service;

import com.cdweb.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService extends  IGeneralService<BookDTO>{
    public List<BookDTO> findAll();
    public BookDTO save(BookDTO bookDTO);
    public BookDTO update(BookDTO bookDTO);
    public BookDTO deleta(long[] ids);
}
