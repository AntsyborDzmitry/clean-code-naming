package com.epam.engx.cleancode.naming.task3;

public class HarshadNumbersPrinter {

    public String print() {
        long limit = 200;
        StringBuilder result = getHarshadNumersForLimitedSequence(limit);
        return result.toString();
    }

    private StringBuilder getHarshadNumersForLimitedSequence(long limit) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if (isHarshadNumber(i)) {
                result.append(i).append("\n");
            }
        }
        return result;
    }

    private boolean isHarshadNumber(int number) {
        int sumOfDigits = getSumOfDigits(number);
        if (sumOfDigits > 0) {
            return number % getSumOfDigits(number) == 0;
        }
        return false;
    }

    private int getSumOfDigits(int number) {
        int sumOfDigit = 0;
        while (number != 0) {
            sumOfDigit += number % 10;
            number = number / 10;
        }
        return sumOfDigit;
    }

}
