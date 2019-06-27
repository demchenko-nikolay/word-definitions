package com.demchenko.wordsfetcher.service;

import com.demchenko.wordsfetcher.bean.Word;
import com.demchenko.wordsfetcher.repository.WordMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordSaverServiceImpl implements WordSaverService {

    @Autowired
    WordMongoRepository repository;

    public void saveWordToDatabase(Word word) {
        repository.save(word);
    }

    public List<Word> findAll() {
        return repository.findAll();
    }
}
