package com.hardis.recrutement.parser.impl;

import com.hardis.recrutement.model.Error;
import com.hardis.recrutement.parser.ParserService;
import com.hardis.recrutement.model.ParserOutputData;
import com.hardis.recrutement.model.Reference;
import com.hardis.recrutement.util.ApplicationConstant;
import com.hardis.recrutement.util.ValidatorUtils;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: MELGADI
 * Date: 20/06/2017
 *
 * Le parseur de l'application
 */
public class ParserServiceImpl implements ParserService {

    public ParserOutputData parseFile(final String fileUrl) throws UnsupportedEncodingException, FileNotFoundException {

        CsvParser parser = getParser();
        List<String[]> allRows = parser.parseAll(getReader(fileUrl));

        ParserOutputData parserOutputData = new ParserOutputData();
        parserOutputData.setInputFile(FilenameUtils.getName(fileUrl));

        if (CollectionUtils.isNotEmpty(allRows)) {
            List<Reference> references = new ArrayList<>();
            List<com.hardis.recrutement.model.Error> errors = new ArrayList<>();

            /**
             * Java 8 implicite stream foreach
             */
            allRows.forEach(line -> {
                if (isValidResource(line)) {
                    references.add(new Reference(line[0], line[1], line[2], line[3]));
                } else {
                    errors.add(getErrorFromLine(line, allRows.indexOf(line)));
                }
            });
            parserOutputData.setReferences(references);
            parserOutputData.setErrors(errors);
        }

        return parserOutputData;
    }

    /**
     *
     * @return Csv parser
     */
    private CsvParser getParser() {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setDelimiter(';');
        return new CsvParser(settings);
    }

    /**
     * is Valide line
     * @param line : the csv line
     * @return is correct or not
     */
    private boolean isValidResource(final String[] line) {
        return line != null
                && line.length == 4 && ValidatorUtils.isValidReferenceNumber(line[0])
                && ValidatorUtils.isValidColor(line[1]) && ValidatorUtils.isDouble(line[2])
                && ValidatorUtils.isInteger(line[3]);
    }

    /**
     *
     * @param line the csv line
     * @param index the line index
     * @return
     */
    private Error getErrorFromLine(final String[] line, final Integer index) {
        final Error error = new Error();
        String errorMessage = null;
        String value = Arrays.toString(line);
        if (line.length != 4) {
            errorMessage = ApplicationConstant.LINE_FORMAT_NOT_VALID;
        } else if (!ValidatorUtils.isValidReferenceNumber(line[0])) {
            errorMessage = ApplicationConstant.NUM_REFERENCE_NOT_VALID;
            value = line[0];
        } else if (!ValidatorUtils.isValidColor(line[1])) {
            errorMessage = ApplicationConstant.COLOR_NOT_VALID;
            value = line[1];
        } else if (!ValidatorUtils.isDouble(line[2])) {
            errorMessage = ApplicationConstant.PRICE_NOT_VALID;
            value = line[2];
        } else if (!ValidatorUtils.isInteger(line[3])) {
            errorMessage = ApplicationConstant.SIZE_NOT_VALID;
            value = line[3];
        }
        error.setMessage(errorMessage);
        error.setLine(index);
        error.setValue(value);
        return error;
    }


    /**
     *
     * @param path file path
     * @return the reader
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     */
    public static Reader getReader(String path) throws UnsupportedEncodingException, FileNotFoundException {
        return new InputStreamReader(new FileInputStream(path), "UTF-8");
    }

}
