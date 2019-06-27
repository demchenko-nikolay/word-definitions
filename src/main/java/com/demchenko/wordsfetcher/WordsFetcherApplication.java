package com.demchenko.wordsfetcher;

import com.demchenko.wordsfetcher.bean.Word;
import com.demchenko.wordsfetcher.service.WordFetcherService;
import com.demchenko.wordsfetcher.service.WordSaverService;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class WordsFetcherApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(WordsFetcherApplication.class, args);

        WordFetcherService wordFetcherService = (WordFetcherService) context.getBean("wordFetcherServiceImpl");
        WordSaverService wordSaverService = (WordSaverService) context.getBean("wordSaverServiceImpl");

        Word word = wordFetcherService.getWordFromDictionary("object");

        wordSaverService.saveWordToDatabase(word);

        List<Word> all = wordSaverService.findAll();

        all.stream().forEach(System.out::println);
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "test");
    }

}
