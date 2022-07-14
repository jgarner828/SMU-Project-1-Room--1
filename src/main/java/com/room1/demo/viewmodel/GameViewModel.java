package com.room1.demo.viewmodel;

import java.util.Objects;

public class GameViewModel {
    private int id;
    private String title;
    private int esrbRating;
    private String description;
    private double price;
    private String studio;
    private int quantity;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getEsrbRating() {
        return esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getStudio() {
        return studio;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEsrbRating(int esrbRating) {
        this.esrbRating = esrbRating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameViewModel that = (GameViewModel) o;
        return id == that.id && esrbRating == that.esrbRating && Double.compare(that.price, price) == 0 && quantity == that.quantity && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(studio, that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrbRating, description, price, studio, quantity);
    }
}
