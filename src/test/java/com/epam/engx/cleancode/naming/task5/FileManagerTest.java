package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class FileManagerTest {

    FileManager fileManager = new FileManager();

    @Test
    public void should_listAllImageFiles() {
        List<String> imageList = fileManager.getImagesFileName();
        Assert.assertNotNull(imageList);
        Assert.assertEquals(1, imageList.size());
        Assert.assertEquals("epam.png", imageList.get(0));
    }

    @Test
    public void should_listAllDocumentFiles() {
        List<String> documentFiles = fileManager.getDocumentFilesName();
        Assert.assertNotNull(documentFiles);
        Assert.assertEquals(1, documentFiles.size());
        Assert.assertEquals("sample.doc", documentFiles.get(0));
    }

    @Test
    public void should_retrieveFile_when_validImage() {
        File image = fileManager.getFile("epam.png");
        Assert.assertTrue(image.exists());
    }

    @Test(expected = InvalidFileTypeException.class)
    public void should_throwException_when_unsupportedImageType() {
        fileManager.getFile("invalidImage.img");
    }

    @Test
    public void should_returnEmpty_when_noImageExists() {
        File image = fileManager.getFile("invalidImage.jpg");
        Assert.assertFalse(image.exists());
    }

    @Test
    public void should_retrieveFile_when_validDocument() {
        File document = fileManager.getFile("sample.doc");
        Assert.assertTrue(document.exists());
    }

    @Test(expected = InvalidFileTypeException.class)
    public void should_throwException_when_unsupportedDocumentType() {
        fileManager.getFile("invalidDoc.java");
    }

    @Test(expected = InvalidFileTypeException.class)
    public void should_throwException_when_retrieveFileWithNoExtension() {
        fileManager.getFile("noExtension");
    }

    @Test
    public void should_returnEmpty_when_noDocumentExists() {
        File document = fileManager.getFile("invalidDoc.pdf");
        Assert.assertFalse(document.exists());
    }
}
