package com.demchenko.wordsfetcher.service;

import com.demchenko.wordsfetcher.bean.Word;

import java.io.IOException;

public interface WordFetcherService {
    Word getWordFromDictionary(String word) throws IOException;
}
