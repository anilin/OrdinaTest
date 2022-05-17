package com.somecompany.textprocessing.wordfrequency.impl;

import com.somecompany.textprocessing.wordfrequency.WordFrequency;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFrequencyAnalyzerImplTest {

    private WordFrequencyAnalyzerImpl wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();

    private static final String testString = "The sun shines over the lake.";
    private static final String longerTestString = "The sun shines over the lake. It is quite rare for the sun to be shining so brightly this time of the year. I hope it shines forever more.";
    @Test
    void calculateHighestFrequency() {
        int frequency = wordFrequencyAnalyzer.calculateHighestFrequency(testString);

        assertEquals(2, frequency);
    }

    @Test
    void calculateFrequencyForWord() {
        int frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(testString, "the");
        assertEquals(2, frequency);

        frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(longerTestString, "ThE");
        assertEquals(4, frequency);
    }

    @Test
    void calculateMostFrequentNWords() {
        List<WordFrequency> mostFrequentNWords = wordFrequencyAnalyzer.calculateMostFrequentNWords(longerTestString, 4);

        assertEquals(4, mostFrequentNWords.size());

        assertEquals("the", mostFrequentNWords.get(0).getWord());
        assertEquals(4, mostFrequentNWords.get(0).getFrequency());

        assertEquals("it", mostFrequentNWords.get(1).getWord());
        assertEquals(2, mostFrequentNWords.get(1).getFrequency());

        assertEquals("shines", mostFrequentNWords.get(2).getWord());
        assertEquals(2, mostFrequentNWords.get(2).getFrequency());

        assertEquals("sun", mostFrequentNWords.get(3).getWord());
        assertEquals(2, mostFrequentNWords.get(3).getFrequency());
    }
}