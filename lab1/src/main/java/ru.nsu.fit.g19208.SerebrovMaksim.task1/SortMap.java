package ru.nsu.fit.g19208.SerebrovMaksim.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortMap {
    public List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> map, Comparator<Map.Entry<String, Integer>> cmp){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(cmp);
        return list;
    }
}
