package com.cdweb.controller;

import com.cdweb.dto.BookDTO;
import com.cdweb.dto.CategoryDTO;
import com.cdweb.dto.UserDTO;
import com.cdweb.service.IBannerService;
import com.cdweb.service.IBookService;
import com.cdweb.service.ICategoryService;
import com.cdweb.service.IUserService;
import com.cdweb.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
public class WebController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private IUserService userService;

//    @GetMapping(value = {"/", "/trang-chu", "/index"})
//    public ModelAndView indexPage() {
//
//        ModelAndView mav = new ModelAndView("index.html");
//        Pageable pageable = PageRequest.of(0, 8);
//        List<BookDTO> hotList = bookService.findByHot(pageable);
//
//        List<BookDTO> newList = bookService.findByNew(pageable);
//
//        List<BookDTO> discountList = bookService.findByDiscount(pageable);
//        mav.addObject("bannerlist", this.bannerService.findAll());
//        mav.addObject("discountlist", discountList);
//        mav.addObject("hotlist", hotList);
//        mav.addObject("newlist", newList);
//
//
//        return mav;
//    }
    @GetMapping("/")
    public String hello(){
        return "hello world";
    }
    @GetMapping("/index")
    public ModelAndView helloWorld(){
        return new ModelAndView("hello.html");
    }


    @GetMapping("/tin-tuc")
    public List<BookDTO> news() {
        Pageable pageable = PageRequest.of(0, 8);
        List<BookDTO> hotList = bookService.findByHot(pageable);
        System.out.println(hotList);
        return hotList;
    }

    @GetMapping("/kiem-tra-don-hang")
    public ModelAndView checkOrder(Principal principal) {
        return principal != null ? new ModelAndView("kiem-tra-don-hang.html") : new ModelAndView("dang-nhap.html");
    }
    @GetMapping("/thong-tin-ca-nhan")
    public ModelAndView profile(Principal principal) {
        return principal != null ? new ModelAndView("thong-tin-ca-nhan.html") : new ModelAndView("dang-nhap.html");
    }

}
