package com.cdweb.controller.web;

import com.cdweb.api.web.BookAPI;
import com.cdweb.api.web.input.BookInput;
import com.cdweb.api.web.output.BookOutput;
import com.cdweb.dto.BookDTO;
import com.cdweb.dto.ShoppingCartDTO;
import com.cdweb.dto.UserDTO;
import com.cdweb.entity.OrderedItemEntity;
import com.cdweb.entity.UserEntity;
import com.cdweb.repository.OrderedItemRepository;
import com.cdweb.service.IBookService;
import com.cdweb.service.IShoppingCartService;
import com.cdweb.service.IUserService;
import com.cdweb.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;

    //  ?category=lang-mang&page=1&limit=5&sort=name&order=asc
    @GetMapping("/danh-sach-san-pham")
    public BookOutput listCustomer(
            @RequestParam(name = "category", required = false, defaultValue = "null") String category,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "12") Integer limit,
            @RequestParam(name = "sort", required = false, defaultValue = "id") String sortName,
            @RequestParam(name = "order", required = false, defaultValue = "ASC") String sortBy,
            @RequestParam(name = "hot", required = false, defaultValue = "false") boolean hot,
            @RequestParam(name = "new", required = false, defaultValue = "false") boolean newBook,
            @RequestParam(name = "sale", required = false, defaultValue = "false") boolean sale,
            @RequestParam(name = "title", required = false, defaultValue = "null") String title
    ) {
        BookOutput bookOutput = new BookOutput();
        Sort sortable = null;

        if ("ASC".equalsIgnoreCase(sortBy)) {
            sortable = Sort.by(sortName).ascending();
        }
        if ("DESC".equalsIgnoreCase(sortBy)) {
            sortable = Sort.by(sortName).descending();
        }
        Pageable pageable = PageRequest.of(page - 1, limit, sortable);
        if (!"null".equalsIgnoreCase(title)) {
            bookOutput.setListResult(bookService.findByTitle(title, pageable));
            bookOutput.setPage(page);
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByTitle(title)) / limit));
        } else if (!"null".equalsIgnoreCase(category)) {
            bookOutput.setListResult(bookService.findByCategory(category, pageable));
            bookOutput.setPage(page);
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByCategory(category)) / limit));
        } else if (hot) {
            bookOutput.setListResult(bookService.findByHot(pageable));
            bookOutput.setPage(page);
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByHot()) / limit));
        } else if (newBook) {
            bookOutput.setListResult(bookService.findByNew(pageable));
            bookOutput.setPage(page);
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countByNew()) / limit));
        } else if (sale) {
            bookOutput.setListResult(bookService.findByDiscount(pageable));
            bookOutput.setPage(page);
            int count = bookService.countByDiscount();
            bookOutput.setTotalPage((int) Math.ceil((double) (count) / limit));
        } else {
            bookOutput.setListResult(bookService.findAll(pageable));
            bookOutput.setPage(page);
            bookOutput.setTotalPage((int) Math.ceil((double) (bookService.countAll()) / limit));
        }
        return bookOutput;
    }

    @GetMapping("/san-pham")
    public ModelAndView productPage(Principal principal) {
        ModelAndView mav = new ModelAndView("san-pham.html");
        UserDTO userDTO;
        if (principal != null) {
            userDTO = this.userService.findByEmail(principal.getName());
        } else {
            userDTO = null;
        }
        mav.addObject("user", userDTO);
        return mav;
    }

    @GetMapping("/chi-tiet-san-pham")
    public ModelAndView bookDetailPage(Principal principal)
    {
        ModelAndView mav = new ModelAndView("chi-tiet-san-pham.html");
        UserDTO userDTO;
        if (principal != null) {
            userDTO = this.userService.findByEmail(principal.getName());
        } else {
            userDTO = null;
        }
        mav.addObject("user", userDTO);
        return mav;
    }


    @GetMapping("/thong-tin-san-pham")
    public BookDTO bookDetailProduct(@RequestParam(name = "id") Long id) {
        return bookService.findById(id);
    }


    @PostMapping(value = "/save-book")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }



    @GetMapping("/autocomplete")
    public List<String> autoComplete(@RequestParam(name = "title") String title){
        return this.bookService.autoCompleteTitle(title);
    }
    
}
