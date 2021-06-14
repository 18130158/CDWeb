package com.cdweb.config;

import com.cdweb.constant.SystemConstant;
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
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user=userRepository.findByEmail(email);
        System.out.println("----------------------"+"\n"+user);
        return Optional.ofNullable(user);
    }
}