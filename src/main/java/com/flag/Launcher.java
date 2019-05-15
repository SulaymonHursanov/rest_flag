package com.flag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @GetMapping("/flag/{countryCode}")
    public ResponseEntity<FlagDTO> getFlag(@PathVariable("countryCode") String countryCode){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://restcountries.eu/rest/v2/alpha/";
        String url = resourceUrl + countryCode + "?fields=name;flag;";
        return restTemplate.getForEntity(url, FlagDTO.class);
    }
}
