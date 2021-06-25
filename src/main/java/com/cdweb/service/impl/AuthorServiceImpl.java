package com.cdweb.service.impl;

import com.cdweb.converter.AuthorConverter;
import com.cdweb.dto.AuthorDTO;
import com.cdweb.entity.AuthorEntity;
import com.cdweb.repository.AuthorRepository;
import com.cdweb.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorConverter authorConverter;
    @Override
    public List<AuthorDTO> findAll() {
        List<AuthorEntity> list=this.authorRepository.findAll();
        List<AuthorDTO> listResult=new ArrayList<>();
        for (AuthorEntity author:list){
            listResult.add(this.authorConverter.toDTO(author));
        }
        return listResult;
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO) {
        return this.authorConverter.toDTO(this.authorRepository.save(this.authorConverter.toEntity(authorDTO)));
    }

}
