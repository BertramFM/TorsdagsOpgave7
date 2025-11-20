package model;

import java.time.LocalDate;

public class Vare {
    private String ean;
    private String name;
    private LocalDate priceDate;
    private double price;
    private int quantity;
    private String unit;

    public Vare(String ean, String name, LocalDate priceDate, double price, int quantity, String unit) {
        this.ean = ean;
        this.name = name;
        this.priceDate = priceDate;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getEan() {
        return ean; }

    public String getName() {
        return name;
    }

    public LocalDate getPriceDate() {
        return priceDate;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
