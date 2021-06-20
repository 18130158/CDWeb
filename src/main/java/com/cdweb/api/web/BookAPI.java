package com.cdweb.api.web;

import com.cdweb.api.web.input.BookInput;
import com.cdweb.api.web.output.BookOutput;
import com.cdweb.dto.BookDTO;
import com.cdweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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


    //  ?category=lang-mang&page=1&limit=5&sort=name&order=asc
    @GetMapping("/api/san-pham")
    public BookOutput listBook(@RequestBody BookInput input) {

        BookOutput bookOutput = new BookOutput();
        Sort sortable = null;

        if ("ASC".equalsIgnoreCase(input.getSortBy())) {
            sortable = Sort.by(input.getSortName()).ascending();
        }
        if ("DESC".equalsIgnoreCase(input.getSortBy())) {
            sortable = Sort.by(input.getSortName()).descending();
        }
        Pageable pageable = PageRequest.of(input.getPage() - 1, input.getLimit(), sortable);
        if ( !"null".equalsIgnoreCase(input.getCategory())) {
            bookOutput.setListResult(bookService.findByCategory(input.getCategory(), pageable));
            bookOutput.setPage(input.getPage());
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByCategory(input.getCategory())) / input.getLimit()));
        } else if (input.isHot()) {
            List<BookDTO> books=bookService.findByHot(pageable);
            bookOutput.setListResult(books);
            bookOutput.setPage(input.getPage());
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByHot()) / input.getLimit()));
        } else if (input.isNewBook()) {
            bookOutput.setListResult(bookService.findByNew(pageable));
            bookOutput.setPage(input.getPage());
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByNew()) / input.getLimit()));
        } else if (input.isSale()) {
            bookOutput.setListResult(bookService.findByDiscount(pageable));
            bookOutput.setPage(input.getPage());
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByDiscount()) /input.getLimit()));
        } else {
            bookOutput.setListResult(bookService.findAll(pageable));
            bookOutput.setPage(input.getPage());
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countAll()) / input.getLimit()));
        }
        return bookOutput;
    }

    @GetMapping("/api/chi-tiet-san-pham")
    public BookDTO bookDetail(@RequestParam(name = "book_id") Long id) {
        return bookService.findById(id);
    }



}
