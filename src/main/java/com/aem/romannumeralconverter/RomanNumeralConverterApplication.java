package com.aem.romannumeralconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aem.romannumeralconverter")
@Configuration
public class RomanNumeralConverterApplication {

    public static void main(String[] args) {

        SpringApplication.run(RomanNumeralConverterApplication.class, args);

    }

}

