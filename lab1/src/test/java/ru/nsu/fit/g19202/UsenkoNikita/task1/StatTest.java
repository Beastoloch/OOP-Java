package ru.nsu.fit.g19202.UsenkoNikita.task1;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.nsu.fit.g19202.UsenkoNikita.task1.ConstantClass.Percent;
import static ru.nsu.fit.g19202.UsenkoNikita.task1.ConstantClass.Separator;

class StatTest {
    @Test
    public void testCmp(){
        WordComparator cmp = new WordComparator();
        Map.Entry<String, Integer> a = new AbstractMap.SimpleEntry<>("a", 1);
        Map.Entry<String, Integer> b = new AbstractMap.SimpleEntry<>("b", 1);
        Map.Entry<String, Integer> c = new AbstractMap.SimpleEntry<>("c", 2);
        assertEquals(-1, cmp.compare(a,b));
        assertEquals(1, cmp.compare(a,c));
    }

    @Test
    public void testWrdWriter() throws IOException {
        StringWriter writer = new StringWriter();
        WordWriter sw = new WordWriter();
        sw.writeStat(writer, Collections.emptyList(), 0);
        assertEquals("", writer.toString());

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        sw.writeStat(writer, list, 1);
        assertEquals("A"
                + Separator
                + "1"
                + Separator
                + "100.0"
                + Percent
                + '\n', writer.toString());
    }

    @Test
    public void testWrdReader() throws IOException {
        WordReader wr1 = new WordReader(Reader.nullReader());
        assertEquals(0, wr1.getWordCounter());
        assertTrue(wr1.getMap().entrySet().isEmpty());

        StringReader reader = new StringReader("A B B");
        WordReader wr2 = new WordReader(reader);
        assertEquals(3, wr2.getWordCounter());
        assertEquals(1, wr2.getMap().get("A"));
        assertEquals(2, wr2.getMap().get("B"));
    }

}
