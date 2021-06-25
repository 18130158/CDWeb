package com.cdweb.repository;

import com.cdweb.entity.OrderedEntity;
import com.cdweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedRepository extends JpaRepository<OrderedEntity, Long> {
    List<OrderedEntity> findAllByUser(UserEntity user);
}
