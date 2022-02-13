package dev.ogabek.java.model;

public class Book {

    private final int image;
    private final String name;
    private final String dollar;
    private final String cent;
    private final float oldPrice;

    public Book(int image, String name, float price, float oldPrice) {
        this.image = image;
        this.name = name;
        this.dollar = String.valueOf((int) price);
        this.cent = String.valueOf(price).substring(String.valueOf(price).indexOf('.') + 1);
        this.oldPrice = oldPrice;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCent() {
        return cent;
    }

    public String getDollar() {
        return dollar;
    }

    public float getOldPrice() {
        return oldPrice;
    }

}