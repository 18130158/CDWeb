package com.cdweb.converter;

import com.cdweb.dto.ShoppingCartDTO;
import com.cdweb.entity.ShoppingCartEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartConverter {
    private ModelMapper modelMapper = new ModelMapper();

    public ShoppingCartDTO toDTO(ShoppingCartEntity shoppingCartEntity) {
        return modelMapper.map(shoppingCartEntity, ShoppingCartDTO.class);
    }

    public ShoppingCartEntity toEntity(ShoppingCartDTO shoppingCartDTO) {
        return modelMapper.map(shoppingCartDTO, ShoppingCartEntity.class);
    }
}
