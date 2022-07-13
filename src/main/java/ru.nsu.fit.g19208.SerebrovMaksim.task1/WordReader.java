package ru.nsu.fit.g19208.SerebrovMaksim.task1;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class WordReader {
    final private Map<String, Integer> map;
    private int wordCounter;
    WordReader(Reader reader) throws IOException {
        map = new HashMap<>();
        StringBuilder wordBuffer = new StringBuilder();
        int letter;
        wordCounter = 0;
        while((letter = reader.read())!=-1){
            if (Character.isLetterOrDigit((char) letter)) {
                wordBuffer.append((char) letter);
            } else if (wordBuffer.length() > 0) {
                var wb = wordBuffer.toString();
                map.merge(wb, 1, Integer::sum);
                wordCounter++;
                wordBuffer.setLength(0);
            }
        }
        if(wordBuffer.length() > 0){
            map.merge(wordBuffer.toString(), 1, Integer::sum);
            wordCounter++;
        }
    }
    public Map<String, Integer> getMap(){
        return map;
    }
    public int getWordCounter(){
        return wordCounter;
    }
}
