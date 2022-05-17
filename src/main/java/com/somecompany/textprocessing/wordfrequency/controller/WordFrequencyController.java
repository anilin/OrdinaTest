package com.somecompany.textprocessing.wordfrequency.controller;

import com.somecompany.textprocessing.wordfrequency.WordFrequency;
import com.somecompany.textprocessing.wordfrequency.WordFrequencyAnalyzer;
import com.somecompany.textprocessing.wordfrequency.impl.WordFrequencyImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/wordfrequency")
public class WordFrequencyController {
    @Inject
    WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{text}/{wordToSearchFor}")
    public Response frequencyForWord(@PathParam("text") String text, @PathParam("wordToSearchFor") String wordToSearchFor) {
        int frequencyForWord = wordFrequencyAnalyzer.calculateFrequencyForWord(text, wordToSearchFor);

        WordFrequency wordFrequency = new WordFrequencyImpl(wordToSearchFor, frequencyForWord);

        return Response.ok(wordFrequency) .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/highest/{text}")
    public Response highestFrequency(@PathParam("text") String text) {
        int highestFrequency = wordFrequencyAnalyzer.calculateHighestFrequency(text);

        return Response.ok(highestFrequency) .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/most/{n}/in/{text}")
    public Response highestFrequency(@PathParam("n") int n, @PathParam("text") String text) {
        List<WordFrequency> mostFrequentNWords = wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);

        return Response.ok(mostFrequentNWords) .build();
    }
}
