package com.cdweb.api.web;

import com.cdweb.dto.UserDTO;
import com.cdweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserAPI {
    @Autowired
    private IUserService userService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping(value = "/api/register")
    public String displayRegistration() {
        return "/web/register";
    }

    @GetMapping(value = "/api/forget-password")
    public String forgetPassword(@RequestBody UserDTO user, Model model) {
        return "forget-password";
    }

    @PostMapping(value = "/api/dang-ki")
    public UserDTO registerUser(@RequestBody UserDTO user, Model model) {
        UserDTO userDTO = userService.sendMail(user);
        return userDTO == null?null:userDTO;
    }

    @RequestMapping(value = "/api/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public UserDTO confirmEmail(@RequestParam(name = "token") String confirmationToken, Model model) {
        UserDTO user = userService.confirmEmail(confirmationToken);
        return user != null?user:null;
    }
}
