package com.example.petshop.Configs;
import com.example.petshop.Repository.IPetRepository;
import com.example.petshop.Repository.PetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfig {
    @Bean
    public IPetRepository petRepository() {
        return new PetRepository();
    }
}
