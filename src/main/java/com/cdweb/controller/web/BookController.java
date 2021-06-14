package com.cdweb.controller.web;

import com.cdweb.dto.BookDTO;
import com.cdweb.service.IBookService;
import com.cdweb.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private IBookService bookService;

    //  ?category=lang-mang&page=1&limit=5&sort=name&order=asc
    @GetMapping("/san-pham")
    public String listCustomer(Model model,
                               @RequestParam(name = "category", required = false, defaultValue = "null") String category,
                               @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(name = "limit", required = false, defaultValue = "12") Integer limit,
                               @RequestParam(name = "sort", required = false, defaultValue = "id") String sort,
                               @RequestParam(name = "order", required = false, defaultValue = "ASC") String order) {

        page = page - 1;
        if (!"null".equals(category)) {
            model.addAttribute("listBook", bookService.findByCategory(category, limit, page * limit + 1, sort, order));
        } else {
            Sort sortable = null;

            if ("ASC".equals(order)) {
                sortable = Sort.by(sort).ascending();
            }
            if ("DESC".equals(order)) {
                sortable = Sort.by(sort).descending();
            }
            Pageable pageable = PageRequest.of(page, limit, sortable);

            List<BookDTO> bookList = bookService.findAll(pageable);

            model.addAttribute("listBook", bookList);
        }
        return "/web/product";
    }

    @GetMapping("/chi-tiet-san-pham")
    public BookDTO bookDetail(@RequestParam(name = "book_id") Long id) {
        return bookService.findById(id);
    }

    @PostMapping(value = "/save-book")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }
}
