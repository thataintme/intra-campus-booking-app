package com.example.demo.Shop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(ShopRepository shopRepository){
        return args->{
            Shop oliv = new Shop("Oliv","grocery",true, "OLVG");
            Shop swagat = new Shop("Swagat","food",false, "SWGT");
            shopRepository.saveAll(
                List.of(oliv,swagat)
            );
    };
    }

}
