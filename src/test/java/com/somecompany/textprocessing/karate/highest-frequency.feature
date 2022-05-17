Feature: Word Frequency

Scenario: Find the highest frequency count of a word in a sentence

Given url 'http://localhost:8080/OrdinaTest/app/wordfrequency/highest/The%20sun%20is%20shining%20brightly%20on%20the%20building%20in%20the%20city%20of%20the%20sun'
When method GET
Then status 200
And match $ == 4