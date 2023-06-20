package org.example;

public class WrongInsertStatement extends RuntimeException {
    public WrongInsertStatement(String message) {
        super(message);
    }
}
