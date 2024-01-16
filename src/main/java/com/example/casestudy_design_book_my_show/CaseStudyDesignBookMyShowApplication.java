package com.example.casestudy_design_book_my_show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CaseStudyDesignBookMyShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyDesignBookMyShowApplication.class, args);
    }

}
