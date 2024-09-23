package org.converter.service.impl;

import org.junit.jupiter.api.Test;

class ConvertYamlTest {

    @Test
    void convert() {
        String yaml = """
            nodded: red
            difficult: 643600505.8291383
            land: once
            dirt:
              highest:
                - true
                - false
                - true
                - 185991079
                - true
                - 512835871.33457613
              sold: atmosphere
              women: -532816671
              went: hurried
              wet: habit
              certain: -1529753398.226221
            anybody: false
            count: 542101562.7521467
            """;

        System.out.println(yaml);
        System.out.println("------");
        ConvertToYaml convertYaml = new ConvertToYaml();

        System.out.println(convertYaml.convert(yaml));
    }
}
