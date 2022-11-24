package com.epam.engx.cleancode.naming.task5.predicates;

import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtensionPredicate implements Predicate<String> {

    private String[] allowedExtensions;

    public FileExtensionPredicate(String[] allowedExtensions) {
        this.allowedExtensions = allowedExtensions;
    }

    @Override
    public boolean test(String fileName) {
        for (String extension : allowedExtensions) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
