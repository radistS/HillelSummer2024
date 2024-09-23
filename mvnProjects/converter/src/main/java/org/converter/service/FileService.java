package org.converter.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import lombok.SneakyThrows;
import org.converter.enums.Extension;

public class FileService {

    /**
     * read from file to string
     * @param file
     * @return
     */
    @SneakyThrows
    public String readFile(File file) {
        return Files.readString(file.toPath());
    }

    /**
     * write to file from string with albility append to file
     * @param file
     * @param content
     * @param append
     */
    @SneakyThrows
    public   void writeFile(File file, String content, boolean append) {
        if (append) {
            Files.write(file.toPath(), content.concat(System.lineSeparator()).getBytes(),
                StandardOpenOption.APPEND);
        } else {
            Files.write(file.toPath(), content.concat(System.lineSeparator()).getBytes());
        }
    }

    /**
     * Create folder if not exist
     * @param folderName
     * @return
     */
    @SneakyThrows
    public File createFolder(File folderName) {
        if (!folderName.exists())
            return Files.createDirectory(folderName.toPath()).toFile();
        return folderName;
    }

    @SneakyThrows
    public File createFile(File fileName) {
        return Files.createFile(fileName.toPath()).toFile();
    }

    /**
     * get file list for file extension
     * @param folder
     * @param extension
     * @return
     */
    public  List<File> getFilesWithExtension(File folder, Extension extension) {
        return Arrays.stream(folder.listFiles()).filter(file ->
                Extension.JSON.equals(extension) ? isJson().test(file.getName())
                    : isYaml().test(file.getName()))
            .toList();
    }

    /**
     * Generate new file names, change extension
     * @param file
     * @param destination
     * @param extension
     * @return
     */
    public File newFileName(File file, File destination,  Extension extension) {
        int lastIndexOf = file.getName().lastIndexOf(".");
        String fileName = file.getName().substring(0, lastIndexOf);
        return new File(destination.getPath() + File.separator + fileName + "." + extension.getExtension());

    }

    // predicats
    public Predicate<String> isJson() {
        return s -> s.endsWith(".json");
    }

    public Predicate<String> isYaml() {
        return s -> s.endsWith(".yaml");
    }
}
