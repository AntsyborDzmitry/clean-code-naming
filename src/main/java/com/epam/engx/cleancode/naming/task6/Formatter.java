package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String PLUS = "+";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = " _ ";
    private static final String NEW_LINE = "\n";


    public String formatKeyValue(String key, String value) {
        String content = key + UNDERSCORE + value;
        String minuses = repeat(MINUS, content.length());

        String borderLine = getFormattedLine(PLUS, minuses);
        String contentLine = getFormattedLine(PIPE, content);

        return borderLine + contentLine + borderLine;

    }

    private String repeat(String symbol, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++){
            result.append(symbol);
        }
        return result.toString();
    }

    private String getFormattedLine(String borderSymbol, String content) {
        return borderSymbol + content + borderSymbol + NEW_LINE;
    }
}
