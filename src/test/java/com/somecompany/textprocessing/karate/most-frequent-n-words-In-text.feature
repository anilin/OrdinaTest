Feature: Word Frequency

Scenario: Calculate the most frequent 'n' words in a sentence

Given url 'http://localhost:8080/OrdinaTest/app/wordfrequency/most/3/in/The%20sun%20is%20shining%20brightly%20on%20the%20building%20in%20the%20city%20of%20the%20sun'
When method GET
Then status 200
And match $ contains {"frequency":4,"word":"the"}
And match $ contains {"frequency":2,"word":"sun"}
And match $ contains {"frequency":1,"word":"brightly"}