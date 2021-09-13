package com.cdweb.controller.web;

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

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView indexPage() {

        ModelAndView mav = new ModelAndView("web/index.html");
        Pageable pageable = PageRequest.of(0, 8);
        List<BookDTO> hotList = bookService.findByHot(pageable);
        List<BookDTO> newList = bookService.findByNew(pageable);
        List<BookDTO> discountList = bookService.findByDiscount(pageable);
        mav.addObject("bannerlist", this.bannerService.findAll());
        mav.addObject("discountlist", discountList);
        mav.addObject("hotlist", hotList);
        mav.addObject("newlist", newList);
        return mav;
    }


    @GetMapping("/tin-tuc")
    public ModelAndView news() {
        return new ModelAndView("web/tin-tuc.html");
    }

    @GetMapping("/gioi-thieu")
    public ModelAndView about() {
        return new ModelAndView("web/gioi-thieu.html");
    }

    @GetMapping("/dich-vu")
    public ModelAndView dichvu() {
        return new ModelAndView("web/dich-vu.html");
    }
    @GetMapping("/lien-he")
    public ModelAndView lienhe() {
        return new ModelAndView("web/lien-he.html");
    }

    @GetMapping("/kiem-tra-don-hang")
    public ModelAndView checkOrder(Principal principal) {
        return principal != null ? new ModelAndView("web/kiem-tra-don-hang.html") : new ModelAndView("web/dang-nhap.html");
    }

    @GetMapping("/thong-tin-ca-nhan")
    public ModelAndView profile(Principal principal) {
        return principal != null ? new ModelAndView("web/thong-tin-ca-nhan.html") : new ModelAndView("web/dang-nhap.html");
    }

}
