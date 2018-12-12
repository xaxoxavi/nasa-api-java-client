package com.esliceu;

import com.esliceu.model.Photos;
import com.esliceu.model.RoverName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class NasaApiJavaClientApplication {

    private static final Logger log = LoggerFactory.getLogger(NasaApiJavaClientApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(NasaApiJavaClientApplication.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(RoversApi roversApi) throws Exception {
        return args -> {
            Photos photos = roversApi.getPhotos(RoverName.Spirit,1000);
            log.info(photos.toString());
        };
    }
}
