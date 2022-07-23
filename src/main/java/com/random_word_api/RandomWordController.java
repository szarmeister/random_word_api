package com.random_word_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
public class RandomWordController {

    private RandomWordService randomWordService;

    @Autowired
    public RandomWordController(RandomWordService randomWordService) {
        this.randomWordService = randomWordService;
    }

    @GetMapping(value = "/get_random_word")
    public String getRandomWord() throws IOException {
        return randomWordService.getRandomWord();
    }

    @GetMapping(value = "/get_word")
    public String getRandomWord(@RequestParam(defaultValue = "5") Integer length) throws IOException {
        return randomWordService.getWordWithSpecificLength(length);
    }

}
