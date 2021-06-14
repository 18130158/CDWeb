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
    Page<BookEntity> findAllByActive(boolean active,Pageable pageable);
    Page<BookEntity> findAllByActiveAndHotBook(boolean active,boolean hotBook,Pageable pageable);
    Page<BookEntity> findAllByActiveAndNewBook(boolean active,boolean newBook,Pageable pageable);



    @Query(value = "select b.* from category_book cb " +
            "join book b on b.id=cb.book_id " +
            "join category c on c.id=cb.category_id " +
            "where cb.code= :code and b.active=false LIMIT=:limit OFFSET=:offset ORDER BY :sort :order", nativeQuery = true)
    public List<BookEntity> findByCategory(@Param("code") String code, @Param("limit") int limit, @Param("offset") int offset,@Param("sort") String sort, @Param("order") String oder);

    @Query(value = "select count(b.*) from book b where b.category_id=:category_id",nativeQuery = true)
    public int countByCategory(@Param("category_id")Long category_id);

    public Page<BookEntity> findByDiscountGreaterThan(double discount,Pageable pageable);



}
