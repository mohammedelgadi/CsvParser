package com.hardis.recrutement.model;

/**
 * User: MELGADI
 * Date: 19/06/2017
 * <p>
 * Classe sera mappée au lignes erronées
 */
public class Error {

    private int line;

    private String message;

    private String value;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
