package com.hardis.recrutement.model;

/**
 * User: MELGADI
 * Date: 19/06/2017
 * <p>
 * La classe des references
 * Cette classe sera mappée automatiquement à l'aide de jackson
 */

public class Reference {

    private String numReference;

    private String color;

    private String price;

    private String size;

    /**
     * Constructeur par defaut
     */
    public Reference() {

    }

    /**
     * @param numReference reference number
     * @param color        the color
     * @param price        the price
     * @param size         the size
     */
    public Reference(String numReference, String color, String price, String size) {
        this.numReference = numReference;
        this.color = color;
        this.price = price;
        this.size = size;
    }

    public String getNumReference() {
        return numReference;
    }

    public void setNumReference(String numReference) {
        this.numReference = numReference;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
