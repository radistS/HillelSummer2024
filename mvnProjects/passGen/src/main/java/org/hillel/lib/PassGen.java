package org.hillel.lib;

import org.apache.commons.lang3.RandomStringUtils;

public class PassGen {

    public String passGen(int digitNumber){
        return RandomStringUtils.randomNumeric(digitNumber);
    }

}
