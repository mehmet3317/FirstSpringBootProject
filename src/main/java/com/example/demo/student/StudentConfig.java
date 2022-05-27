package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {
            Student mehmet = new Student(
                    "mehmet",
                    "mehmet@gmail.com",
                    LocalDate.of(1995, Month.AUGUST,13)
            );
            Student alex = new Student(
                    "mehmet",
                    "alex@gmail.com",
                    LocalDate.of(1997, Month.JANUARY,13)
            );

            repository.saveAll(
                    List.of(mehmet, alex)
            );
        };
    }
}
