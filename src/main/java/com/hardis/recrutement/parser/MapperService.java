package com.hardis.recrutement.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hardis.recrutement.model.ParserOutputData;

import java.io.IOException;

/**
 * User: MELGADI
 * Date: 20/06/2017
 *
 * Service mapper
 */
public interface MapperService {

    /**
     * @param parserOutputData the data to map
     * @return file mapped as json  using jackson-xml
     * @throws IOException
     */
    String mapToJson(final ParserOutputData parserOutputData) throws IOException;

    /**
     * @param parserOutputData the data to map
     * @return file mapped as xml using jackson-xml
     * @throws JsonProcessingException
     */
    String mapToXml(final ParserOutputData parserOutputData) throws JsonProcessingException;
}
