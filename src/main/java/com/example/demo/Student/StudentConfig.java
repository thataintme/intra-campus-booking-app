package com.example.demo.Student;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args->{
            Student alice = new Student("18bcx1234","Alice","LH1",524,9874563210L);
            Student bob = new Student("18bcx5678","Bob","MH1",234,9876543210L);
            studentRepository.saveAll(
                List.of(alice,bob)
                );
        };
    }
}
