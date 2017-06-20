package com.hardis.recrutement.parser.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hardis.recrutement.model.ParserOutputData;
import com.hardis.recrutement.parser.MapperService;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * User: MELGADI
 * Date: 20/06/2017
 */
public class MapperServiceImpl implements MapperService {

    @Override
    public String mapToJson(final ParserOutputData parserOutputData) throws IOException {
        return new ObjectMapper().writeValueAsString(parserOutputData);
    }

    @Override
    public String mapToXml(final ParserOutputData parserOutputData) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(parserOutputData);
    }
}
