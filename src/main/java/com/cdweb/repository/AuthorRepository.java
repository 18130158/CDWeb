package com.cdweb.repository;

import com.cdweb.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    @Query(value = "select a.* from author a where a.id=:id",nativeQuery = true)
    AuthorEntity findAuthorById(@Param("id") Long id);

}
