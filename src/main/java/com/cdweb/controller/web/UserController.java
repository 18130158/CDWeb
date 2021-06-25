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

import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;


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

    @GetMapping("/user")
    public UserDTO user(Principal principal) {
        return principal != null ? this.userService.findByEmail(principal.getName()) : null;
    }

    @GetMapping("/quen-mat-khau")
    public ModelAndView forgetPasswordPage() {
        ModelAndView mav = new ModelAndView("quen-mat-khau.html");
        mav.addObject("message", false);
        return mav;
    }

    @PostMapping("/send-mail-forget-password")
    public ModelAndView newPassword(@ModelAttribute("user") UserDTO user) {
        UserDTO userDTO = userService.sendMailForgetPassword(user.getEmail());
        ModelAndView mav = new ModelAndView("quen-mat-khau.html");
        mav.addObject("message", true);
        return mav;
    }

    @RequestMapping(value = "/forget-password", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView forgetPassword(@RequestParam(name = "token") String confirmationToken) {
        UserDTO user = userService.confirmEmailForgetPassword(confirmationToken);
        ModelAndView mav = new ModelAndView("doi-mat-khau.html");
        mav.addObject("forget", true);
        mav.addObject("email", user.getEmail());
        return mav;
    }

    @PostMapping("/change-password")
    public ModelAndView changePassword(@ModelAttribute("user") UserDTO user, Principal principal) {
        UserDTO userDTO = userService.changePassword(user);
        if (principal == null) {
            return new ModelAndView("dang-nhap.html");
        } else {
            return new ModelAndView("thong-tin-ca-nhan.html");
        }
    }

    @GetMapping("/doi-mat-khau")
    public ModelAndView changePasswordPage(Principal principal) {
        ModelAndView mav = new ModelAndView("doi-mat-khau.html");
        mav.addObject("forget", false);
        mav.addObject("email", principal.getName());
        return mav;
    }

    @GetMapping("/check-password")
    public boolean checkPassword(@RequestParam(name = "password") String password, Principal principal) {
        return this.userService.checkPass(password, principal.getName());
    }
}
