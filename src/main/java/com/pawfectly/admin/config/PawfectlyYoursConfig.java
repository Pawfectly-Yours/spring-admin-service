package com.pawfectly.admin.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"com.pawfectly.common", "com.pawfectly.admin"})
@Configuration
@ComponentScan({"com.pawfectly.common"})
@EnableJpaAuditing
@EnableJpaRepositories({"com.pawfectly.admin", "com.pawfectly.common"})
public class PawfectlyYoursConfig {
}
