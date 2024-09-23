package org.converter.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Test;

class ConvertJsonTest {

    @Test
    void convert_oneObject() {
        String json = """
            {
              "id": 1,
              "firstName": "Paulo",
              "lastName": "Goligly",
              "email": "pgoligly0@ed.gov",
              "gender": "Male"
            }
            """;
        System.out.println(json);
        System.out.println("-------");
        ConvertToJson convertJson = new ConvertToJson();
        System.out.println(convertJson.convert(json));
    }

    @Test
    void convert_moreThanOneObject() {
        String json = """
             [{
               "id": 1,
               "first_name": "Cayla",
               "last_name": "Holtaway",
               "email": "choltaway0@senate.gov",
               "gender": "Female"
             }, {
               "id": 2,
               "first_name": "Archibald",
               "last_name": "Kyberd",
               "email": "akyberd1@patch.com",
               "gender": "Male"
             }, {
               "id": 3,
               "first_name": "Leslie",
               "last_name": "Bridgewood",
               "email": "lbridgewood2@alexa.com",
               "gender": "Polygender"
             }]
            """;
        ConvertToJson convertJson = new ConvertToJson();
        assertThrows(MismatchedInputException.class, () -> convertJson.convert(json));
    }
}
