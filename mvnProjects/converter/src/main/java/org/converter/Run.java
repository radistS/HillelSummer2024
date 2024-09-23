package org.converter;

import java.io.File;
import java.util.List;
import org.converter.enums.Extension;
import org.converter.service.Convert;
import org.converter.service.FileService;
import org.converter.service.impl.ConvertToJson;
import org.converter.service.impl.ConvertToYaml;

public class Run {

    public static void main(String[] args) {
        System.out.println("json <> yaml : converter");

        if (args.length == 0) {
            System.out.println("please put correct path as application argument ....");
        }

        File file = new File(args[0]);

        FileService fileService = new FileService();
        System.out.println("json files");
        List<File> jsons =  fileService.getFilesWithExtension(file, Extension.JSON); // create list with json files

        System.out.println("yaml files");
        List<File> yamls =  fileService.getFilesWithExtension(file, Extension.YAML); // create list with yaml file

        // create folder converted
        File convertedFolder = new File(args[0] + File.separator + "converted");
        fileService.createFolder(convertedFolder);

        // convert json -> yaml
        jsons.forEach(f -> {
            System.out.println("star process with file " + f.getName());
            Convert convert = new ConvertToYaml();  // create service
            String content = fileService.readFile(f); // read from file
            fileService.writeFile( // write to file
                fileService.newFileName(f, convertedFolder, Extension.YAML), // create new file name + new folder
                convert.convert(content), // convert json -> map -> yaml
                false ); // not append
        });

        // convert yaml -> json
        yamls.forEach(f -> {
            System.out.println("star process with file " + f.getName());
            Convert convert = new ConvertToJson();
            String content = fileService.readFile(f);
            fileService.writeFile(
                fileService.newFileName(f, convertedFolder, Extension.JSON),
                convert.convert(content),
                false );
        });
    }
}
