package com.cdweb.converter;

import com.cdweb.dto.AuthorDTO;
import com.cdweb.entity.AuthorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {
    private ModelMapper modelMapper = new ModelMapper();

    public AuthorDTO toDTO(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDTO.class);
    }
    public AuthorEntity toEntity(AuthorDTO authorDTO){
        return modelMapper.map(authorDTO,AuthorEntity.class);
    }
}
