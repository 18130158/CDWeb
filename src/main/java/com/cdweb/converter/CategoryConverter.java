package com.cdweb.converter;

import com.cdweb.dto.CategoryDTO;
import com.cdweb.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    private ModelMapper modelMapper=new ModelMapper();
    private CategoryDTO toDTO(CategoryEntity categoryEntity){
        return modelMapper.map(categoryEntity,CategoryDTO.class);
    }
    private CategoryEntity toEntity(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }
}
