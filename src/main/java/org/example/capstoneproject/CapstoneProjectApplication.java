package org.example.capstoneproject;

import org.example.capstoneproject.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapstoneProjectApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(CapstoneProjectApplication.class, args);
//        var repository = context.getBean(UserRepository.class);
//        repository.findAll().forEach(e -> System.out.println(e.getUsername()));
//        repository.deleteAll();
//        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
