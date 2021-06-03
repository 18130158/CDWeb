package com.cdweb.repository;

import com.cdweb.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}
