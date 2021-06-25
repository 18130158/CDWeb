package com.cdweb.service;

import com.cdweb.dto.AuthorDTO;

import java.util.List;

public interface IAuthorService {
    List<AuthorDTO> findAll();

    AuthorDTO save(AuthorDTO authorDTO);
}
