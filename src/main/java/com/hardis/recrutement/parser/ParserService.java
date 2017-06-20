package com.hardis.recrutement.parser;

import com.hardis.recrutement.model.ParserOutputData;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * User: MELGADI
 * Date: 19/06/2017
 * <p>
 * Service parser
 */
public interface ParserService {

    ParserOutputData parseFile(final String fileUrl) throws UnsupportedEncodingException, FileNotFoundException;
}
