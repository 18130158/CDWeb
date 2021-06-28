package com.cdweb.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
    @GetMapping("/admin")
    public ModelAndView getAdminPage() {
        return new ModelAndView("/admin/index.html");
    }

}
