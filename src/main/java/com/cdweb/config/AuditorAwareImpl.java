package com.cdweb.config;

import com.cdweb.entity.UserEntity;
import com.cdweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<UserEntity> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserEntity> getCurrentAuditor() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.ofNullable(userRepository.findByUserName(username));
    }
}