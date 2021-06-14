package com.cdweb.config;//package com.cdweb.config;

import com.cdweb.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
	@Bean
	public AuditorAware<UserEntity> auditorProvider() {
		return new AuditorAwareImpl();
	}

}
