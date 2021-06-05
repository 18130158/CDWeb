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

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping(value = "/register")
    public String displayRegistration(@RequestBody UserDTO user, Model model) {
        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(@RequestBody UserDTO user, Model model) {
        UserDTO userDTO = userService.sendMail(user);
        if (userDTO==null) {
            model.addAttribute("message", "This email already exists!");
            return "error";
        } else {
            model.addAttribute("email", userDTO.getEmail());
            return "successfulRegisteration";
        }
    }
    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmEmail(@RequestParam(name = "token") String confirmationToken, Model model) {
       UserDTO user= userService.confirmEmail(confirmationToken);
        if (user!= null) {
            return "/web/home";
        } else {
            return null;
        }
    }



}
