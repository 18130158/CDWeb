package com.cdweb.repository;

import com.cdweb.entity.OrderedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedItemRepository extends JpaRepository<OrderedItemEntity, Long> {
}
