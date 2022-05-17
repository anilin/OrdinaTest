package com.somecompany.textprocessing.karate;

import com.intuit.karate.junit5.Karate;

public class KarateTest {

    @Karate.Test
    Karate wordFrequency() {
        return Karate.run("word-frequency").relativeTo(getClass());
    }

    @Karate.Test
    Karate highestFrequency() {
        return Karate.run("highest-frequency").relativeTo(getClass());
    }

    @Karate.Test
    Karate mostFrequentNWords() {
        return Karate.run("most-frequent-n-words-In-text").relativeTo(getClass());
    }
}