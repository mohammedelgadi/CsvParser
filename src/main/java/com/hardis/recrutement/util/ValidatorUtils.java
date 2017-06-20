/**
 * Copyright (c) 2010, vsc-technologies - www.voyages-sncf.com
 * All rights reserved.
 * <p>
 * Les presents codes sources sont proteges par le droit d'auteur et
 * sont la propriete exclusive de VSC Technologies.
 * Toute representation, reproduction, utilisation, exploitation, modification,
 * adaptation de ces codes sources sont strictement interdits en dehors
 * des autorisations formulees expressement par VSC Technologies,
 * sous peine de poursuites penales.
 * <p>
 * Usage of this software, in source or binary form, partly or in full, and of
 * any application developed with this software, is restricted to the
 * customer.s employees in accordance with the terms of the agreement signed
 * with VSC-technologies.
 */
package com.hardis.recrutement.util;

import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * User: MELGADI
 * Date: 19/06/2017
 */
public class ValidatorUtils {


    /**
     *
     * @param args programme inputs
     * @return les entrées sont correctes ?
     */
    public static boolean isValidInput(final String[] args) {
        return args.length == 3 && isValideInputUrl(args[0])
                && isValidFormat(args[1]) && isValideOutputUrl(args[2]);
    }

    public static boolean isValidReferenceNumber(final String refNum) {
        return StringUtils.isNotEmpty(refNum) && refNum.length() == ApplicationConstant.REF_NUMBER_LENGTH;
    }

    public static boolean isValidColor(final String color) {
        switch (color) {
            case "R":
            case "G":
            case "B":
                return true;
            default:
                return false;
        }
    }

    public static boolean isInteger(final String size) {
        try {
            Integer.parseInt(size);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String price) {
        try {
            Double.parseDouble(price);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *
     * @param url   input file url
     * @return is valid url
     */
    private static boolean isValideInputUrl(final String url) {
        final boolean result = StringUtils.isNotEmpty(url) && Files.exists(Paths.get(url));
        if (!result) {
            System.out.println(String.format(ApplicationConstant.FILE_NOT_EXIST, 1, url));
        }
        return result;
    }

    /**
     *
     * @param format [JSON | XML]
     * @return  is valide format
     */
    private static boolean isValidFormat(final String format) {
        final String extension = format.toUpperCase();
        final boolean result = StringUtils.isNotEmpty(extension) && (extension.equals(ApplicationConstant.JSON)
                || extension.equals(ApplicationConstant.XML));
        if (!result) {
            System.out.println(String.format(ApplicationConstant.FORMAT_NOT_CORRECT, 2, extension));
        }
        return result;
    }

    /**
     *
     * @param url output directory
     * @return is exist
     */
    private static boolean isValideOutputUrl(final String url) {
        final boolean result = Files.exists(Paths.get(url)) && Files.isDirectory(Paths.get(url));
        if (!result) {
            System.out.println(String.format(ApplicationConstant.FILE_NOT_EXIST, 3, url));
        }
        return result;
    }

}
