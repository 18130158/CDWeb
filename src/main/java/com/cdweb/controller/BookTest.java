package com.cdweb.controller;

import com.cdweb.dto.BookDTO;
import com.cdweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BookTest {
    @Autowired
    private IBookService  bookService;


//    @GetMapping("/")
//    public String home() {
//        return "redirect:/san-pham-1";
//    }
    @GetMapping("/san-pham-1")
    public String index(Model model, HttpServletRequest request
            , RedirectAttributes redirect) {
        request.getSession().setAttribute("productlist", null);

        if(model.asMap().get("success") != null)
            redirect.addFlashAttribute("success",model.asMap().get("success").toString());
        return "redirect:/san-pham/page?page=1";
    }
    @GetMapping("/san-pham/page/{pageNumber}")
    public String showEmployeePage(HttpServletRequest request,
                                   @PathVariable int pageNumber, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("productlist");
        int pagesize = 9;
        List<BookDTO> list = bookService.findAll();
        System.out.println(list.size());
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pagesize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("productlist", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 5, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        String baseUrl = "/san-pham/page/";

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("employees", pages);



        return "list";
    }
}
