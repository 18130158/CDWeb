package com.cdweb.converter;

import com.cdweb.dto.NewsDTO;
import com.cdweb.entity.NewsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NewsConverter {
    private ModelMapper modelMapper = new ModelMapper();

    private NewsDTO toDTO(NewsEntity newsEntity) {
        return modelMapper.map(newsEntity, NewsDTO.class);
    }

    private NewsEntity toEntity(NewsDTO newsDTO) {
        return modelMapper.map(newsDTO, NewsEntity.class);
    }
}
