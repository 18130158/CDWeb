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

    @GetMapping(value = {"/", "/trang-chu", "/index"})
    public ModelAndView indexPage(Principal principal) {


        ModelAndView mav = new ModelAndView("index.html");
        UserDTO userDTO;
        if (principal!=null) {
           userDTO=this.userService.findByEmail(principal.getName());
        }else{
            userDTO=null;
        }
        mav.addObject("user",userDTO);
        Pageable pageable = PageRequest.of(0, 8);
        List<BookDTO> hotList = bookService.findByHot(pageable);

        List<BookDTO> newList = bookService.findByNew(pageable);

        List<BookDTO> discountList = bookService.findByDiscount(pageable);

        mav.addObject("discountlist", discountList);
        mav.addObject("hotlist", hotList);
        mav.addObject("newlist", newList);


        return mav;
    }


    @GetMapping("/tin-tuc")
    public List<BookDTO> news() {
        Pageable pageable = PageRequest.of(0, 8);
        List<BookDTO> hotList = bookService.findByHot(pageable);
        System.out.println(hotList);
        return hotList;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("title", "Welcome to My Page");

        model.addAttribute("userInfo", userInfo);

        return "/web/adminPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "/web/logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "/web/userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "/web/403Page";
    }


}
