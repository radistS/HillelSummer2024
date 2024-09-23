package org.converter.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.converter.enums.Extension;
import org.junit.jupiter.api.Test;

class FileServiceTest {

    @Test
    void readFile() {
        FileService fileService = new FileService();
        System.out.println(fileService.readFile(new File("src/test/java/org/converter/service/text.json")));
        System.out.println(fileService.readFile(new File("src/test/java/org/converter/service/text.yaml")));
    }

    @Test
    void writeFile() {
        FileService fileService = new FileService();
        fileService.writeFile(new File("text.txt"), "new content", true);
    }

    @Test
    void createFolder() {
    }

    @Test
    void createFile() {
    }

    @Test
    void fileCount() {
        FileService fileService = new FileService();
        File folder = new File("src/test/java/org/converter/service/files");

        assertEquals(3, fileService.getFilesWithExtension(folder, Extension.JSON).size());
        assertEquals(1, fileService.getFilesWithExtension(folder, Extension.YAML).size());
    }

    @Test
    void nameConverterTest(){
        FileService fileService = new FileService();
        File file = new File("src/test/java/org/converter/service/text.json");
        File destination = new File("src/test/java/org/converter/service/convert/text.json");
        assertTrue(file.isFile());
        String result = "text.yaml";
        assertEquals(result, fileService.newFileName(file, destination, Extension.YAML).getName());
    }
}
