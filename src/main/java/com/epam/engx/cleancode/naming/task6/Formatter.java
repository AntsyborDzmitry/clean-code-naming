package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String BORDER_SYMBOL = "+";
    private static final String CONTENT_BORDER_SYMBOL = "|";
    private static final String LINE_SYMBOL = "-";
    private static final String CONTENT_DELIMITER = " _ ";
    private static final String NEW_LINE = "\n";


    public String formatKeyValue(String key, String value) {
        String content = key + CONTENT_DELIMITER + value;
        String borderLineContent = repeat(LINE_SYMBOL, content.length());

        String borderLine = getFormattedLine(BORDER_SYMBOL, borderLineContent);
        String contentLine = getFormattedLine(CONTENT_BORDER_SYMBOL, content);

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
