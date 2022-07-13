package ru.nsu.fit.g19208.SerebrovMaksim.task1;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import static ru.nsu.fit.g19208.SerebrovMaksim.task1.ConstantClass.InputFileIndex;
import static ru.nsu.fit.g19208.SerebrovMaksim.task1.ConstantClass.MaxArgsCount;
import static ru.nsu.fit.g19208.SerebrovMaksim.task1.ConstantClass.MinArgsCount;
import static ru.nsu.fit.g19208.SerebrovMaksim.task1.ConstantClass.OutputFileIndex;

public class Main {
    public static void main(String[] args) {
        if ((args.length >= MinArgsCount) && (args.length <= MaxArgsCount)) {
            try {
                String pathIn = args[InputFileIndex];
                Reader reader = new FileReader(pathIn);
                WordReader wordReader = new WordReader(reader);
                var list = new SortMap();
                WordWriter writer = new WordWriter();
                if (args.length == (InputFileIndex + 1)) {
                    BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(System.out));
                    writer.writeStat(outfile, list.sortMap(wordReader.getMap(), new WordComparator()), wordReader.getWordCounter());
                }
                if (args.length == (OutputFileIndex + 1)) {
                    String pathOut = args[OutputFileIndex];
                    Writer outfile = new FileWriter(pathOut);
                    writer.writeStat(outfile, list.sortMap(wordReader.getMap(), new WordComparator()), wordReader.getWordCounter());
                    outfile.close();
                }
                reader.close();
            } catch (IOException e) {
                System.err.println("Error while reading file: " + e.getLocalizedMessage());
            }
        }
    }
}

