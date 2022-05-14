package com.somecompany.textprocessing.wordfrequency.impl;

import com.somecompany.textprocessing.wordfrequency.WordFrequency;
import com.somecompany.textprocessing.wordfrequency.WordFrequencyAnalyzer;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {
    @Override
    public int calculateHighestFrequency(String text) {
        Optional<WordFrequencyImpl> result = Stream.of(text.split("\s")).
                collect(
                        Collectors.groupingBy(
                                String::toLowerCase,
                                Collectors.counting())).
                entrySet().stream().
                    map(e -> new WordFrequencyImpl(e.getKey(), e.getValue().intValue())).
                    max(Comparator.comparingInt(WordFrequencyImpl::getFrequency));

        return result.get().getFrequency();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        long count = Stream.of(text.split("\s")).
                filter(p -> p.equalsIgnoreCase(word)).
                count();

        return (int)count;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        List<WordFrequency> result = Stream.of(text.split("\s")).
                collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting())).
        entrySet().stream().
                map( p -> new WordFrequencyImpl(p.getKey(), p.getValue().intValue())).
                sorted((p1, p2) -> {
                    int frequencyCompare = p2.getFrequency() - p1.getFrequency();
                    int compareResult = frequencyCompare == 0 ? p1.getWord().compareTo(p2.getWord()) : frequencyCompare;
                    return compareResult;
                }).
                limit(n).
                collect(Collectors.toList());

        return result;
    }
}
