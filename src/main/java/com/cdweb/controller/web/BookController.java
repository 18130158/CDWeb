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
    @Autowired
    private OrderedItemRepository orderedItemRepository;
    @Autowired
    private IShoppingCartService shoppingCartService;

    //  ?category=lang-mang&page=1&limit=5&sort=name&order=asc
    @GetMapping("/san-pham")
    public ModelAndView listCustomer(
            @RequestParam(name = "category", required = false, defaultValue = "0") long category,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "12") Integer limit,
            @RequestParam(name = "sort", required = false, defaultValue = "id") String sortName,
            @RequestParam(name = "order", required = false, defaultValue = "ASC") String sortBy,
            @RequestParam(name = "hot", required = false, defaultValue = "false") boolean hot,
            @RequestParam(name = "new", required = false, defaultValue = "false") boolean newBook,
            @RequestParam(name = "sale", required = false, defaultValue = "false") boolean sale
    ) {
        ModelAndView mav = new ModelAndView("san-pham.html");
        BookOutput bookOutput = new BookOutput();
        Sort sortable = null;

        if ("ASC".equals(sortBy)) {
            sortable = Sort.by(sortName).ascending();
        }
        if ("DESC".equals(sortBy)) {
            sortable = Sort.by(sortBy).descending();
        }
        Pageable pageable = PageRequest.of(page - 1, limit, sortable);
        if (category != 0) {
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
        mav.addObject("output", bookOutput);
        return mav;
    }


    @GetMapping("/chi-tiet-san-pham")
    public BookDTO bookDetail(@RequestParam(name = "book_id") Long id) {
        return bookService.findById(id);
    }

    @PostMapping(value = "/save-book")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }

    @GetMapping("/them-san-pham")
    public List<ShoppingCartDTO> addProduct(@RequestParam(name = "book_id", required = false, defaultValue = "0") Long book_id, Principal principal) {
        System.out.println(book_id);
        if (principal==null){
            System.out.println("null");
            return null;
        }
        String email = principal.getName();

        return this.shoppingCartService.addProduct(book_id, email);
    }
    @GetMapping("/shopping-cart")
    public ModelAndView shoppingCart(Principal principal){
        if (principal==null){
           return new ModelAndView("dang-nhap.html");
        }
        String email = principal.getName();
        ModelAndView mav=new ModelAndView("gio-hang.html");
        List<ShoppingCartDTO> cartList=this.shoppingCartService.getProduct(email);
        double total=0;
        for (ShoppingCartDTO cart:cartList){
            total+=cart.getBook().getPrice()*(1-cart.getBook().getDiscount()/100)* cart.getQuantity();
        }
        mav .addObject("total", BookDTO.formatPrice(total));
        mav.addObject("cartlist",cartList);
        return mav;
    }
}
