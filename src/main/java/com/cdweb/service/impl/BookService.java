package com.cdweb.service.impl;

import com.cdweb.converter.BookConverter;
import com.cdweb.dto.AuthorDTO;
import com.cdweb.dto.BookDTO;
import com.cdweb.dto.CategoryDTO;
import com.cdweb.entity.AuthorEntity;
import com.cdweb.entity.BookEntity;
import com.cdweb.entity.CategoryEntity;
import com.cdweb.repository.AuthorRepository;
import com.cdweb.repository.BookRepository;
import com.cdweb.repository.CategoryRepository;
import com.cdweb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<BookDTO> findAll() {
        return null;
    }

    @Override
    public BookDTO save(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();


        if (bookDTO.getId() != null) {
            BookEntity oldBookEntity = bookRepository.findOneById(bookDTO.getId());
            bookEntity = bookConverter.toEntity(bookDTO, oldBookEntity);
        } else {
            bookEntity = bookConverter.toEntity(bookDTO);
        }


        List<CategoryEntity> categoryList = this.categoryRepository.findAll();
        List<CategoryEntity> newCategoryList = new ArrayList<>();
        for (CategoryDTO cateDTO : bookDTO.getCategoryList()) {
            for (CategoryEntity cate : categoryList) {
                if (cateDTO.getCode().equals(cate.getCode())) {
                    newCategoryList.add(cate);
                    break;
                }
            }
        }
        bookEntity.setCategoryList(newCategoryList);


        List<AuthorEntity> authorList = this.authorRepository.findAll();
        List<AuthorEntity> newAuthorList = new ArrayList<>();
        for (AuthorDTO authorDTO : bookDTO.getAuthorList()) {
            for (AuthorEntity author : authorList) {
                if (authorDTO.getId()==author.getId()) {
                    newAuthorList.add(author);
                    break;
                }
            }
        }
        bookEntity.setAuthorList(newAuthorList);

        bookEntity=bookRepository.save(bookEntity);

        return bookConverter.toDTO(bookEntity);
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        return null;
    }

    @Override
    public void delete(long[] ids) {

        for(long item: ids) {
            bookRepository.deleteById(item);
        }
    }
    @Override
    public int totalItem() {
        return (int) bookRepository.count();
    }

    @Override
    public List<BookDTO> findAll(Pageable pageable) {
        List<BookDTO> results = new ArrayList<>();
        List<BookEntity> entities = bookRepository.findAll(pageable).getContent();
        for (BookEntity item: entities) {
            BookDTO newDTO = bookConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

}
