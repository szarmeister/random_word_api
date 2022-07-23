package com.random_word_api;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class WordSplitter {
    private static final List<String> wordsPaths = Arrays.asList(
            "D:\\Projekty\\random_word_api\\src\\main\\resources\\random_words\\words_5.txt",
            "D:\\Projekty\\random_word_api\\src\\main\\resources\\random_words\\words_6.txt",
            "D:\\Projekty\\random_word_api\\src\\main\\resources\\random_words\\words_7.txt");


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Projekty\\random_word_api\\src\\main\\resources\\random_words\\english_words.txt"));
        String line;

        for (String path : wordsPaths) {
            File file = new File(path);
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("New file created!");
                }
            }
        }

        while ((line = bufferedReader.readLine()) != null) {
            if (line.length() == 5) {
                FileWriter fileWriter = new FileWriter(wordsPaths.get(0), true);
                fileWriter.append(line);
                fileWriter.append('\n');
                fileWriter.close();
            } else if (line.length() == 6) {
                FileWriter fileWriter = new FileWriter(wordsPaths.get(1), true);
                fileWriter.append(line);
                fileWriter.append('\n');
                fileWriter.close();
            } else if (line.length() == 7) {
                FileWriter fileWriter = new FileWriter(wordsPaths.get(2), true);
                fileWriter.append(line);
                fileWriter.append('\n');
                fileWriter.close();
            }

        }
    }
}
