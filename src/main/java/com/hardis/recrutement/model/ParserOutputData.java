package com.hardis.recrutement.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * User: MELGADI
 * Date: 19/06/2017
 */
@JacksonXmlRootElement(localName = "report")
public class ParserOutputData {

    String inputFile;

    List<Reference> references;

    List<Error> errors;

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
