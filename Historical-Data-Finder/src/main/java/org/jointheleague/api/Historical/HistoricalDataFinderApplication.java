package org.jointheleague.api.Historical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication

public class HistoricalDataFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HistoricalDataFinderApplication.class, args);
    }

}

