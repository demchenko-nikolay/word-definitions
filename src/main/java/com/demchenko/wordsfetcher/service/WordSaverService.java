package com.demchenko.wordsfetcher.service;

import com.demchenko.wordsfetcher.bean.Word;

import java.util.List;

public interface WordSaverService {
    void saveWordToDatabase(Word word);
    List<Word> findAll();
}
