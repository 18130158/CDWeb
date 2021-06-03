package com.cdweb.converter;

import com.cdweb.dto.OrderedItemDTO;
import com.cdweb.entity.OrderedItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderedItemConverter {
    private ModelMapper modelMapper = new ModelMapper();

    private OrderedItemDTO toDTO(OrderedItemEntity orderedItemEntity) {
        return modelMapper.map(orderedItemEntity, OrderedItemDTO.class);
    }

    private OrderedItemEntity toEntity(OrderedItemDTO orderedItemDTO) {
        return modelMapper.map(orderedItemDTO, OrderedItemEntity.class);
    }
}
