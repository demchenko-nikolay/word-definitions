package com.demchenko.wordsfetcher.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String definition;
    private String partOfSpeech;
    private List<String> synonyms;
    private List<String> typeOf;
    private List<String> hasTypes;
    private List<String> examples;
}
