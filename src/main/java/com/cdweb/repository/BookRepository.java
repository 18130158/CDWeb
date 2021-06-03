package com.cdweb.repository;

import com.cdweb.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findOneById(Long id);
}
