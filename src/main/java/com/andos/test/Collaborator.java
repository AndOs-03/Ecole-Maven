package com.andos.test;

public class Collaborator {

    public String transformString(String input) {
        return doStuff();
    }

    private String doStuff() {
        return "someString";
    }
}
