package com.demchenko.wordsfetcher.repository;

import com.demchenko.wordsfetcher.bean.Word;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WordMongoRepository extends MongoRepository<Word, String> {
}
