package com.cdweb.converter;

import com.cdweb.dto.BookDTO;
import com.cdweb.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BookDTO toDTO(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDTO.class);
    }

    public BookEntity toEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, BookEntity.class);
    }

    public BookEntity toEntity(BookDTO bookDTO, BookEntity bookEntity) {
        bookEntity.setId(bookDTO.getId());
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setActive(bookDTO.isActive());
        bookEntity.setShortDescription(bookDTO.getShortDescription());
        bookEntity.setDescription(bookDTO.getDescription());
        bookEntity.setPrice(bookDTO.getPrice());
        bookEntity.setPage(bookDTO.getPage());
        bookEntity.setPublisher(bookDTO.getPublisher());
        bookEntity.setQuantity(bookDTO.getQuantity());
        bookEntity.setMediaList(bookEntity.getMediaList());
        return bookEntity;
    }
}
