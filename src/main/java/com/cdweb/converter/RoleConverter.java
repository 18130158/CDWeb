package com.cdweb.converter;

import com.cdweb.dto.RoleDTO;
import com.cdweb.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    private ModelMapper modelMapper = new ModelMapper();

    private RoleDTO toDTO(RoleEntity roleEntity) {
        return modelMapper.map(roleEntity, RoleDTO.class);
    }

    private RoleEntity roleEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, RoleEntity.class);
    }
}
