package com.cdweb.converter;

import com.cdweb.dto.CommentDTO;
import com.cdweb.entity.CommentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    private ModelMapper modelMapper = new ModelMapper();

    private CommentDTO toDTO(CommentEntity commentEntity) {
        return modelMapper.map(commentEntity, CommentDTO.class);
    }

    private CommentEntity toEntity(CommentDTO commentDTO) {
        return modelMapper.map(commentDTO, CommentEntity.class);
    }
}
