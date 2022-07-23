package com.random_word_api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RandomWordDAO {
    @Value("classpath:random_words/words_5.txt")
    private Resource words5;

    @Value("classpath:random_words/words_6.txt")
    private Resource words6;

    @Value("classpath:random_words/words_7.txt")
    private Resource words7;

    public List<String> getChosenWordsList(int length) throws IOException {
        List<String> words = new ArrayList<>();
        InputStream inputStream = switch(length) {
            case 6 -> words6.getInputStream();
            case 7 -> words7.getInputStream();
            default -> words5.getInputStream();
        };

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            words.add(line);
        }

        return words;
    }
}
