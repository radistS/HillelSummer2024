package com.hillel.lesson_11.lombok;

public class RunUser {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Jack");
        user.setAge(22);

        System.out.println(user);
    }

}
