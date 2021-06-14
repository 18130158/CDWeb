package com.cdweb.service.impl;

import com.cdweb.converter.BookConverter;
import com.cdweb.dto.BookDTO;
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
public class BookServiceImpl implements IBookService {
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

        List<BookDTO> results = new ArrayList<>();
        List<BookEntity> list = bookRepository.findAll();

        for (BookEntity book : list) {
            results.add(this.bookConverter.toDTO(book));
        }
        return results;
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
        if (bookDTO.getAuthor() != null) {
            AuthorEntity author = this.authorRepository.findAuthorById(bookDTO.getAuthor().getId());
            bookEntity.setAuthor(author);
        }
        CategoryEntity category = this.categoryRepository.findCategoryById(bookDTO.getCategory().getId());
        bookEntity.setCategory(category);

        bookEntity = bookRepository.save(bookEntity);

        return bookConverter.toDTO(bookEntity);
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        return null;
    }

    @Override
    public void delete(long[] ids) {

        for (long item : ids) {
            bookRepository.deleteById(item);
        }
    }


    @Override
    public List<BookDTO> findAll(Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findAllByActive(true, pageable).getContent();
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }

    @Override
    public List<BookDTO> findByCategory(String code, int limit, int offset, String sort, String order) {
        List<BookEntity> booklist = bookRepository.findByCategory(code, limit, offset, sort, order);
        List<BookDTO> bookResult = new ArrayList<>();
        for (BookEntity book : booklist) {
            bookResult.add(this.bookConverter.toDTO(book));
        }
        return bookResult;
    }

    @Override
    public long countByCategory(String category) {
        if ("null".equals(category)) {
            return this.bookRepository.count();
        } else {
            Long category_id = this.categoryRepository.findByCode(category);
            return this.bookRepository.countByCategory(category_id);
        }
    }

    @Override
    public BookDTO findById(Long id) {
        return this.bookConverter.toDTO(this.bookRepository.findOneById(id));
    }

    @Override
    public List<BookDTO> findByHot(Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findAllByActiveAndHotBook(true,true, pageable).getContent();
        System.out.println(bookEntityList);
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }

    @Override
    public List<BookDTO> findByNew(Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findAllByActiveAndNewBook(true,true, pageable).getContent();
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }

    @Override
    public List<BookDTO> findByDiscount(Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findByDiscountGreaterThan(0,pageable).getContent();
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }


}
