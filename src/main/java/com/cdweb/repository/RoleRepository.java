package com.cdweb.repository;

import com.cdweb.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

        @Query(value = "select role.name from role join role_user on role.id=role_user.role_id where role_user.user_id=:userId",nativeQuery = true)
    List<String> getRoleNames(@Param("userId") Long userId);
}
