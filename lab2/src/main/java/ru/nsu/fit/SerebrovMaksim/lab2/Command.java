package ru.nsu.fit.SerebrovMaksim.lab2;

import ru.nsu.fit.SerebrovMaksim.lab2.exceptions.CalculatorException;

import java.util.List;

public interface Command {
    void execute(Context ctx, List<String> arguments) throws CalculatorException;
}
