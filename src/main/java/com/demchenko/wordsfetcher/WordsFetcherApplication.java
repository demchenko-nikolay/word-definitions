package com.demchenko.wordsfetcher;

import com.demchenko.wordsfetcher.service.WordFetcherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class WordsFetcherApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(WordsFetcherApplication.class, args);

        WordFetcherService wordFetcherService = (WordFetcherService) context.getBean("wordFetcherServiceImpl");

        wordFetcherService.getWordFromDictionary("hint");
    }

}
