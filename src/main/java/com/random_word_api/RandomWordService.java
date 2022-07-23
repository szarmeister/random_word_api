package com.random_word_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class RandomWordService {

    private RandomWordDAO randomWordDAO;

    @Autowired
    public RandomWordService(RandomWordDAO randomWordDAO) {
        this.randomWordDAO = randomWordDAO;
    }

    public String getRandomWord() throws IOException {
        Random random = new Random();
        List<String> wordsList = randomWordDAO.getChosenWordsList(random.nextInt(3) + 5);
        return wordsList.get(random.nextInt(wordsList.size()));
    }

    public String getWordWithSpecificLength(int length) throws IOException {
        Random random = new Random();
        List<String> wordsList = randomWordDAO.getChosenWordsList(length);
        return wordsList.get(random.nextInt(wordsList.size()));
    }

}
