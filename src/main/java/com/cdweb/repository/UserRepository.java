package com.cdweb.repository;

import com.cdweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserNameAndStatus(String userName,int status);

    UserEntity findByUserName(String username);
}
