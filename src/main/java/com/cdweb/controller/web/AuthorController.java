package com.cdweb.controller.web;

import com.cdweb.dto.AuthorDTO;
import com.cdweb.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @PostMapping("/add-author")
    public AuthorDTO addAuthor(@RequestBody AuthorDTO authorDTO){
        return authorService.save(authorDTO);
    }
}
