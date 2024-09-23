package org.converter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.converter.service.Convert;
import org.yaml.snakeyaml.Yaml;

public class ConvertToJson implements Convert {

    // yaml -> map -> json string
    @SneakyThrows
    @Override
    public String convert(String source) {
        ObjectMapper objectMapper = new ObjectMapper(); // json string to map
        Yaml yaml = new Yaml();                         // map to yaml

        return objectMapper
            .writerWithDefaultPrettyPrinter()            //create pretty json
            .writeValueAsString(                         // string to json
                yaml.load(source));                      // convert yaml to string
    }
}
