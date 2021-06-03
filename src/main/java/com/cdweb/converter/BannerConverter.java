package com.cdweb.converter;

import com.cdweb.dto.BannerDTO;
import com.cdweb.entity.BannerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BannerConverter {
    private ModelMapper modelMapper = new ModelMapper();

    public BannerDTO toDTO(BannerEntity bannerEntity) {
        return modelMapper.map(bannerEntity, BannerDTO.class);
    }
    public BannerEntity toEntity(BannerDTO bannerDTO){
        return modelMapper.map(bannerDTO,BannerEntity.class);
    }
}
