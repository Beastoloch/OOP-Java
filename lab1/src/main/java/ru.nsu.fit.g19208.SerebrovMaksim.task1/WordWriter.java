package ru.nsu.fit.g19208.SerebrovMaksim.task1;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import static ru.nsu.fit.g19208.SerebrovMaksim.task1.Percent;
import static ru.nsu.fit.g19208.SerebrovMaksim.task1.Separator;

public class WordWriter {

    public void writeStat(Writer out, List<Map.Entry<String, Integer>> list, int total) throws IOException {
        for (var pair : list) {
            String per = Double.toString(Math.floor((float)pair.getValue() / total * 10000) / 100f);
            out.append(pair.getKey())
                    .append(Separator)
                    .append(pair.getValue().toString())
                    .append(Separator)
                    .append(per)
                    .append(Percent)
                    .append("\n");
            out.flush();
        }
    }
}
