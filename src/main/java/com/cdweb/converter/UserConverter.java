package com.cdweb.converter;

import com.cdweb.dto.UserDTO;
import com.cdweb.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    private ModelMapper modelMapper = new ModelMapper();

    private UserDTO toDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    private UserEntity toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
