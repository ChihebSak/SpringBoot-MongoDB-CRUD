package com.acsiesbitar.esbitaracsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class EsbitarAcsiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsbitarAcsiApplication.class, args);
    }

    }

