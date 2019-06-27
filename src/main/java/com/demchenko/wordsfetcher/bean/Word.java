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
public class Word {
    private String word;
    private List<Result> results;
    private Syllables syllables;
    private Pronunciation pronunciation;
    private double frequency;
}