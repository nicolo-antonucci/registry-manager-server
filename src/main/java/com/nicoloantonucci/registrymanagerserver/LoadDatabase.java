package com.nicoloantonucci.registrymanagerserver;

import com.nicoloantonucci.registrymanagerserver.repositories.RegistryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LogManager.getLogger();

    @Bean
    CommandLineRunner initDatabase(RegistryRepository repository) {
        return args -> {
        };
    }
}
