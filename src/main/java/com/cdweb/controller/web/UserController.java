package com.cdweb.controller.web;

import com.cdweb.converter.UserConverter;
import com.cdweb.dto.UserDTO;
import com.cdweb.repository.ConfirmationTokenRepository;
import com.cdweb.repository.UserRepository;
import com.cdweb.service.IUserService;
import com.cdweb.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    BCryptPasswordEncoder encoder;


    @PostMapping(value = "/dang-ki")
    public ModelAndView registerUser(@ModelAttribute("User") UserDTO user) {
        UserDTO userDTO = userService.sendMail(user);
        ModelAndView mav = new ModelAndView("dang-ki.html");
        mav.addObject("message", "Mời bạn xác nhận tài khoản qua email: " + userDTO.getEmail());
        return mav;
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmEmail(@RequestParam(name = "token") String confirmationToken, Model model) {
        UserDTO user = userService.confirmEmail(confirmationToken);
        return new ModelAndView("dang-nhap.html");
    }

    @GetMapping("/check-mail")
    public UserDTO checkMail(@RequestParam(name = "email") String email) {
        UserDTO user = userService.findByEmail(email);
        return user;
    }

    @GetMapping("/dang-nhap")
    public ModelAndView loginPage(@RequestParam(name = "error", required = false, defaultValue = "false") boolean error) {
        ModelAndView mav = new ModelAndView("dang-nhap.html");
        if (error) {
            mav.addObject("error", "Email hoặc mật khẩu không chính xác!");
            return mav;
        }

        return mav;
    }

    @GetMapping("/dang-ki")
    public ModelAndView registorPage() {
        ModelAndView mav = new ModelAndView("dang-ki.html");
        mav.addObject("mesage");
        return mav;
    }


}
