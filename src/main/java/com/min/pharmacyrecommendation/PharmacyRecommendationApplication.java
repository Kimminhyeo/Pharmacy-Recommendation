package com.min.pharmacyrecommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PharmacyRecommendationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmacyRecommendationApplication.class, args);
    }

}
