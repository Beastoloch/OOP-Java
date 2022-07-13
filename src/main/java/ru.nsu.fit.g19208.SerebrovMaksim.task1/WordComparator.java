package ru.nsu.fit.g19208.SerebrovMaksim.task1;

import java.util.Comparator;
import java.util.Map;

public class WordComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> firstPair, Map.Entry<String, Integer> secondPair) {
        int result = secondPair.getValue().compareTo(firstPair.getValue());
        if (result == 0)
            result = firstPair.getKey().compareTo(secondPair.getKey());
        return result;
    }
}