package com.cdweb.repository;

import com.cdweb.entity.OrderedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<OrderedEntity, Long> {
}
