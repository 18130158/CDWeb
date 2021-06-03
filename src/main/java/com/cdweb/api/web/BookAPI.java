package com.cdweb.api.web;

import com.cdweb.dto.BookDTO;
import com.cdweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookAPI {

    @Autowired
    private IBookService bookService;
    @PostMapping(value = "/api/book")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {

        return bookService.save(bookDTO);
    }

    @PutMapping("/api/book")
    public BookDTO updateNew(@RequestBody BookDTO bookDTO) {
        return null;
    }

    @DeleteMapping("/api/book")
    public void deleteBook(@RequestBody long[] ids) {
        System.out.println("ok");
    }
}
