package com.hillel.lesson_09.coll;

import java.util.Objects;

public class TestSetColl {

    int a;
    int b;

    public TestSetColl(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestSetColl that = (TestSetColl) o;
        return a == that.a && b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "TestSetColl{" +
            "a=" + a +
            ", b=" + b +
            '}';
    }
}
