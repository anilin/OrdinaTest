package com.somecompany.textprocessing;

import com.somecompany.textprocessing.wordfrequency.WordFrequency;
import com.somecompany.textprocessing.wordfrequency.WordFrequencyAnalyzer;
import com.somecompany.textprocessing.wordfrequency.impl.WordFrequencyAnalyzerImpl;

import java.util.List;

public class TextProcessingMain {
    public static void main(String[] args) {
        String inputSentence = args[0];
        String frequencyForWordInputValue = args[1];
        int mostFrequentNwordsInputValue = Integer.parseInt(args[2]);

        System.out.println("Input = '" + inputSentence + "', " + frequencyForWordInputValue + ", " + mostFrequentNwordsInputValue);

        validateArguments(args, frequencyForWordInputValue);

        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        int highestFrequency = wordFrequencyAnalyzer.calculateHighestFrequency(inputSentence);
        int frequencyForWord = wordFrequencyAnalyzer.calculateFrequencyForWord(inputSentence, frequencyForWordInputValue);
        List<WordFrequency> mostFrequentNWords = wordFrequencyAnalyzer.calculateMostFrequentNWords(inputSentence, mostFrequentNwordsInputValue);

        System.out.printf("Highest Frequency = %s%n", highestFrequency);
        System.out.printf("Frequency For Word %s = %s%n", frequencyForWordInputValue, frequencyForWord);
        System.out.printf("Most Frequent 'n' words = %s", mostFrequentNWords);
    }

    private static void validateArguments(String[] args, String frequencyForWordInputValue) {
        if(args.length != 3) {
            System.out.println("Please enter a sentence with 3 arguments as follows:");
            System.out.println("1) A sentence in double-quotes which will be analyzed for the word frequency analysis.");
            System.out.println("2) The second argument is the frequency of a specific word that you want to check. End off with a number which will indicate the amount of most frequent words you would like to see.");
            System.out.println("3) End off with a number which will indicate the amount of most frequent words you would like to see.");
            System.out.println("Example: 'The sun shines over the lake', sun, 3");

            System.exit(0);
        }
        if(!frequencyForWordInputValue.matches("\\w+")) {
            System.out.println("The second argument must be a word");
            System.exit(0);
        }
        if(!args[2].matches("\\d+")) {
            System.out.println("The last argument must be a number");
            System.exit(0);
        }
    }
}
