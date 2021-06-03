package com.cdweb.converter;

import com.cdweb.dto.OrderedDTO;
import com.cdweb.entity.OrderedEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderedConverter {
    private ModelMapper modelMapper = new ModelMapper();

    private OrderedDTO toDTO(OrderedEntity orderedEntity) {
        return modelMapper.map(orderedEntity, OrderedDTO.class);
    }

    private OrderedEntity toEntity(OrderedDTO orderedDTO) {
        return modelMapper.map(orderedDTO, OrderedEntity.class);
    }
}
