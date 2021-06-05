package com.cdweb.api.web;

import com.cdweb.api.web.output.BookOutput;
import com.cdweb.dto.BookDTO;
import com.cdweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public BookDTO updateNew(@RequestBody BookDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return bookService.save(model);
    }

    @DeleteMapping("/api/book")
    public void deleteBook(@RequestBody long[] ids) {
        bookService.delete(ids);
    }


    @GetMapping(value = "/new")
    public BookOutput showNew(@RequestParam("page") int page,
                              @RequestParam("limit") int limit) {
        BookOutput result = new BookOutput();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setListResult(bookService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (bookService.totalItem()) / limit));
        return result;
    }
}
