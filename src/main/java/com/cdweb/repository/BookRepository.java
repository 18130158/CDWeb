package com.cdweb.repository;

import com.cdweb.dto.NewsDTO;
import com.cdweb.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findOneById(Long id);

    Page<BookEntity> findAll(Pageable pageable);

    Page<BookEntity> findAllByActive(boolean active, Pageable pageable);

    Page<BookEntity> findAllByActiveAndHotBook(boolean active, boolean hotBook, Pageable pageable);

    Page<BookEntity> findAllByActiveAndNewBook(boolean active, boolean newBook, Pageable pageable);

    Page<BookEntity> findAllByActiveAndCategoryCode(boolean active, String category, Pageable pageable);


    public Page<BookEntity> findByActiveAndDiscountGreaterThan(boolean active, double discount, Pageable pageable);


    public int countAllByActiveAndCategoryCode(boolean active, String category_code);

    public int countAllByActiveAndHotBook(boolean active, boolean hot_book);


    public int countAllByActiveAndNewBook(boolean active, boolean new_book);

    public int countAllByActive(boolean active);

    public int countAllByActiveAndDiscountGreaterThan(boolean active, double discount);

    public Page<BookEntity> findByActiveAndTitleContains(boolean b, String title, Pageable pageable);

    public int countAllByActiveAndTitleContains(boolean active, String title);

    public List<BookEntity> findByActiveAndTitleContains(boolean active, String title);
}
