package com.demchenko.wordsfetcher.service;

import java.io.IOException;

public interface WordFetcherService {
    String getWordFromDictionary(String word) throws IOException;
}
