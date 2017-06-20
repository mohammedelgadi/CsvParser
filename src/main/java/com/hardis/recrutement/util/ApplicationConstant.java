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

/**
 * User: MELGADI
 * Date: 19/06/2017
 */
public class ApplicationConstant {

    public static final String FILE_NOT_EXIST = "param[%s] : Directory or File not exist %s";

    public static final String FORMAT_NOT_CORRECT = "param[%s] : Format %s not correct [XML | JSON]";

    public static final String JSON = "JSON";

    public static final String XML = "XML";

    public static final String DOT = ".";

    public static final Integer REF_NUMBER_LENGTH = 10;


    /**
     * Error Messages
     */
    public static final String COMMON_ERROR_MESSAGE = "Incorrect value of ";

    public static final String NUM_REFERENCE_NOT_VALID = COMMON_ERROR_MESSAGE + "reference number";

    public static final String COLOR_NOT_VALID = COMMON_ERROR_MESSAGE + "color";

    public static final String PRICE_NOT_VALID = COMMON_ERROR_MESSAGE + "price";

    public static final String SIZE_NOT_VALID = COMMON_ERROR_MESSAGE + "size";

    public static final String LINE_FORMAT_NOT_VALID = "Line format not valid";

    /**
     * Constructeur privé
     */
    private ApplicationConstant(){

    }
}
