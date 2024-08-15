package com.hillel.lesson_09.coll;

import java.util.ArrayList;
import java.util.List;

public class ALinit {
    public static void main(String[] args) {
        List<String> arrS = new ArrayList<>(15); // 10
        ArrayList<String> arrSt = new ArrayList<>(2_000); // 10


        System.out.println(arrS.size());
        System.out.printf("arrS: %s\n", arrS);
//        arrS.set(4, null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(null);
        arrS.add(4, null);
        System.out.println(arrS.size());
        System.out.printf("arrS: %s\n", arrS);

        arrS.add(0, "first");
        System.out.println(arrS.indexOf(null));




    }
}
