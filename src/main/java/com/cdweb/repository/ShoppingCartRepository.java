package com.cdweb.repository;

import com.cdweb.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity,Long> {
}
