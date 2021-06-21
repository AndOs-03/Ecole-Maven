package com.andos.test;

public class Service {

    private Collaborator collaborator;

    public Service(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public String performService(String input) {
        return collaborator.transformString(input);
    }
}
