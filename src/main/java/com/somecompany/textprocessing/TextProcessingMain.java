package com.somecompany.textprocessing;

public class TextProcessingMain {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Please enter a sentence for the word frequency analysis. End with a number which will indicate the amount of most frequent words you would like to see.");
            System.exit(0);
        }
        if(!args[args.length - 1].matches("\\d+")) {
            System.out.println("The last argument must be a number");
            System.exit(0);
        }
    }
}
