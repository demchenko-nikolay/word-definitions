package com.demchenko.wordsfetcher.service;

import com.demchenko.wordsfetcher.service.WordFetcherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WordFetcherServiceImpl implements WordFetcherService {

    RestTemplate restTemplate;

    @Value("${word.api.url}")
    String dictionaryUrl;

    @Value("${word.api.header.key.name}")
    String headerKeyName;

    @Value("${word.api.header.key.value}")
    String headerKeyValue;

    @Value("${word.api.header.user.agent.value}")
    String userAgentValue;

    public WordFetcherServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public String getWordFromDictionary(String word) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(headerKeyName, headerKeyValue);
        headers.set("user-agent", userAgentValue);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(dictionaryUrl + word, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
