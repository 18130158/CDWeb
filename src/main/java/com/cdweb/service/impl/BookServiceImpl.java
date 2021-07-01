package com.cdweb.service.impl;

import com.cdweb.converter.BookConverter;
import com.cdweb.dto.BookDTO;
import com.cdweb.entity.AuthorEntity;
import com.cdweb.entity.BookEntity;
import com.cdweb.entity.CategoryEntity;
import com.cdweb.entity.MediaEntity;
import com.cdweb.repository.AuthorRepository;
import com.cdweb.repository.BookRepository;
import com.cdweb.repository.CategoryRepository;
import com.cdweb.repository.MediaRepository;
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
    private MediaRepository mediaRepository;

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
//        if (bookDTO.getAuthor() != null) {
//            AuthorEntity author = this.authorRepository.findAuthorById(bookDTO.getAuthor().getId());
//            bookEntity.setAuthor(author);
//        }
        CategoryEntity category = this.categoryRepository.findCategoryById(bookDTO.getCategory().getId());
        bookEntity.setCategory(category);
        bookEntity = bookRepository.save(bookEntity);
        MediaEntity mediaEntity = new MediaEntity();
        mediaEntity.setPath(bookEntity.getMediaList().get(0).getPath());
        mediaEntity.setBook(bookEntity);
        mediaRepository.save(mediaEntity);
        return bookConverter.toDTO(this.bookRepository.findOneById(bookEntity.getId()));
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
    public List<BookDTO> findByCategory(String category_code, Pageable pageable) {
        List<BookEntity> booklist = bookRepository.findAllByActiveAndCategoryCode(true, category_code, pageable).getContent();
        List<BookDTO> bookResult = new ArrayList<>();
        for (BookEntity book : booklist) {
            bookResult.add(this.bookConverter.toDTO(book));
        }
        return bookResult;
    }

    @Override
    public int countByCategory(String category_code) {
        if ("null".equalsIgnoreCase(category_code)) {
            return this.bookRepository.countAllByActive(true);
        } else {
            return this.bookRepository.countAllByActiveAndCategoryCode(true, category_code);
        }
    }

    @Override
    public BookDTO findById(Long id) {
        return this.bookConverter.toDTO(this.bookRepository.findOneById(id));
    }

    @Override
    public List<BookDTO> findByHot(Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findAllByActiveAndHotBook(true, true, pageable).getContent();
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }

    @Override
    public List<BookDTO> findByNew(Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findAllByActiveAndNewBook(true, true, pageable).getContent();
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }

    @Override
    public List<BookDTO> findByDiscount(Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findByActiveAndDiscountGreaterThan(true, 0, pageable).getContent();
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }

    @Override
    public int countByHot() {
        return this.bookRepository.countAllByActiveAndHotBook(true, true);
    }

    @Override
    public int countByNew() {
        return this.bookRepository.countAllByActiveAndNewBook(true, true);
    }

    @Override
    public int countAll() {
        return this.bookRepository.countAllByActive(true);
    }

    @Override
    public int countByDiscount() {
        return this.bookRepository.countAllByActiveAndDiscountGreaterThan(true, 0);
    }

    @Override
    public List<BookDTO> findByTitle(String title, Pageable pageable) {
        List<BookDTO> bookList = new ArrayList<>();
        List<BookEntity> bookEntityList = this.bookRepository.findByActiveAndTitleContains(true, title, pageable).getContent();
        for (BookEntity book : bookEntityList) {
            bookList.add(this.bookConverter.toDTO(book));
        }
        return bookList;
    }

    @Override
    public int countByTitle(String title) {
        return this.bookRepository.countAllByActiveAndTitleContains(true, title);
    }

    @Override
    public List<String> autoCompleteTitle(String title) {
        List<BookEntity> bookEntityList = this.bookRepository.findByActiveAndTitleContains(true, title);
        List<String> list = new ArrayList<>();
        for (BookEntity book : bookEntityList) {
            list.add(book.getTitle());
        }
        return list;
    }
}
