Feature: Word Frequency

Scenario: Check the frequency a word appears in a sentence

Given url 'http://localhost:8080/OrdinaTest/app/wordfrequency/The%20sun%20is%20shining%20brightly%20on%20the%20building%20in%20the%20city%20of%20the%20sun/suns'
When method GET
Then status 200
And match $.frequency == 3
And match $.word == "the"