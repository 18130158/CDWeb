package com.cdweb.converter;

import com.cdweb.dto.AuthorDTO;
import com.cdweb.entity.AuthorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {
    @Autowired
    private ModelMapper modelMapper;

    public AuthorDTO toDTO(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDTO.class);
    }
    public AuthorEntity toEntity(AuthorDTO authorDTO){
        return modelMapper.map(authorDTO,AuthorEntity.class);
    }
}
