package com.somecompany.textprocessing.wordfrequency.impl;

import com.somecompany.textprocessing.wordfrequency.WordFrequency;

import java.util.Objects;

public class WordFrequencyImpl implements WordFrequency {
    private final int frequency;
    private String word;

    public WordFrequencyImpl(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordFrequencyImpl that = (WordFrequencyImpl) o;
        return frequency == that.frequency && word.equals(that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, word);
    }

    @Override
    public String toString() {
        return "WordFrequencyImpl{" +
                "frequency=" + frequency +
                ", word='" + word + '\'' +
                '}';
    }
}
