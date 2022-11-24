package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.predicates.FileExtensionPredicate;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FileManager {

    private static final String[] IMAGE_TYPES = {"jpg", "png"};
    private static final String[] DOCUMENT_TYPES = {"pdf", "doc"};

    private final String basePath = PropertyUtil.loadProperty("basePath");

    public File getFile(String fileName) {
        validateFileType(fileName);
        final String directoryPath = basePath + File.separator;
        return Paths.get(directoryPath, fileName).toFile();
    }

    public List<String> getImagesFileName() {
        return getFileNamesFromDirectory(basePath, IMAGE_TYPES);
    }

    public List<String> getDocumentFilesName() {
        return getFileNamesFromDirectory(basePath, DOCUMENT_TYPES);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtensionPredicate imageExtensionsPredicate = new FileExtensionPredicate(IMAGE_TYPES);
        return !imageExtensionsPredicate.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtensionPredicate documentExtensionsPredicate = new FileExtensionPredicate(DOCUMENT_TYPES);
        return !documentExtensionsPredicate.test(fileName);
    }

    private List<String> getFileNamesFromDirectory(String directoryPath, String[] allowedExtensions) {
        final FileExtensionPredicate predicate = new FileExtensionPredicate(allowedExtensions);
        FilenameFilter filter = getFilterByPredicate(predicate);
        String[] fileNames = getFilteredFileNamesFromDirectory(directoryPath, filter);
        return fileNames != null ? Arrays.asList(fileNames) : Collections.<String>emptyList();
    }

    private FilenameFilter getFilterByPredicate(final FileExtensionPredicate predicate) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String str) {
                return predicate.test(str);
            }
        };
    }

    private String[] getFilteredFileNamesFromDirectory(String directoryPath, FilenameFilter filter) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory.list(filter);
    }

    private void validateDirectory(File directory) {
        if (isNotDirectory(directory)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directory.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File directory) {
        return !directory.isDirectory();
    }

}