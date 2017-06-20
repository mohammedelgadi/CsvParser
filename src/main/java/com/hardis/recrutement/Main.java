package com.hardis.recrutement;

import com.hardis.recrutement.model.ParserOutputData;
import com.hardis.recrutement.parser.MapperService;
import com.hardis.recrutement.parser.ParserService;
import com.hardis.recrutement.parser.impl.MapperServiceImpl;
import com.hardis.recrutement.parser.impl.ParserServiceImpl;
import com.hardis.recrutement.util.ApplicationConstant;
import com.hardis.recrutement.util.ValidatorUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: MELGADI
 * Date: 19/06/2017
 */
public class Main {

    /**
     * Suffix du nom des fichiers à generer
     */
    private static final String OUTPUT_SUFFIX_FILE_NAME = "Ref_";

    public static void main(final String[] args) {

        /**
         * Si les inputs ne sont pas valides il faut afficher le message
         */
        if (!ValidatorUtils.isValidInput(args)) {
            System.err.println("To run the application : java -jar [JAR-NAME] [INPUT FILE] [OUT-PUT FORMAT (JSON|XML)] [OUTPUT DIRECTORY]");
        }

        final String fileToParse = args[0];
        final String outputFormat = args[1];
        final String outputLocation = args[2];


        ParserService parser = new ParserServiceImpl();
        MapperService mapper = new MapperServiceImpl();
        ParserOutputData outputData;

        try {

            final File outputFile = getOutputFile(outputFormat, outputLocation);
            outputData = parser.parseFile(fileToParse);
            if (outputFormat.equalsIgnoreCase(ApplicationConstant.JSON)) {
                FileUtils.writeStringToFile(outputFile, mapper.mapToJson(outputData));
            } else {
                FileUtils.writeStringToFile(outputFile, mapper.mapToXml(outputData));
            }

        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    private static File getOutputFile(final String format, final String url) throws IOException {

        String outputUrl = url + OUTPUT_SUFFIX_FILE_NAME + new SimpleDateFormat("MMddyyyy_HHmmss").format(new Date());
        outputUrl += ApplicationConstant.DOT + format.toLowerCase();

        return new File(outputUrl);
    }


}
