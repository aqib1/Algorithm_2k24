package org.algorithms.io.polymorphism;

public class Developer extends Person {
    private String programmingLanguage;

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}
