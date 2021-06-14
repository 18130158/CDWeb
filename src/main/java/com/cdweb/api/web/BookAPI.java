package com.cdweb.api.web;

import com.cdweb.api.web.output.BookOutput;
import com.cdweb.dto.BookDTO;
import com.cdweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookAPI {
    @Autowired
    private IBookService bookService;

    @PostMapping(value = "/api/book")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }

    @PutMapping("/api/book")
    public BookDTO updateNew(@RequestBody BookDTO bookDTO, @PathVariable("id") long id) {
        bookDTO.setId(id);
        return bookService.save(bookDTO);
    }

    @DeleteMapping("/api/book")
    public void deleteBook(@RequestBody long[] ids) {
        bookService.delete(ids);
    }


    @GetMapping("/api/san-pham")
    public BookOutput listCustomer(Model model,
                                      @RequestParam(name = "category", required = false, defaultValue = "null") String category,
                                      @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(name = "limit", required = false, defaultValue = "6") Integer limit,
                                      @RequestParam(name = "sort", required = false, defaultValue = "name") String sort,
                                      @RequestParam(name = "order", required = false, defaultValue = "ASC") String order) {

        page = page - 1;
        if (!"null".equals(category)) {
            BookOutput result=new BookOutput();
            result.setListResult(bookService.findByCategory(category, limit, page * limit + 1, sort, order));
            result.setTotalPage((int) Math.ceil((double) (bookService.countByCategory(category)) / limit));
            return result;
        } else {
            Sort sortable = null;
            if ("ASC".equals(order)) {
                sortable = Sort.by(sort).ascending();
            }
            if ("DESC".equals(order)) {
                sortable = Sort.by(sort).descending();
            }
            Pageable pageable = PageRequest.of(page, limit, sortable);

            BookOutput result=new BookOutput();

            result.setListResult(bookService.findAll(pageable));

            result.setTotalPage((int) Math.ceil((double) (bookService.countByCategory(category)) / limit));

            return result;
        }
    }
    @GetMapping("/api/chi-tiet-san-pham")
    public BookDTO bookDetail(@RequestParam(name = "book_id") Long id) {
        return bookService.findById(id);
    }
}
