package com.room1.demo.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "t_shirt")
public class Shirt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "t_shirt_id")
    @PrimaryKeyJoinColumn
    private int id;

    @NotEmpty
    @Length(max =20)
    private String size;

    @NotEmpty
    @Length(max =20)
    private String color;

    @NotEmpty
    @Length(max =255)
    private String description;

    @NotEmpty
    private double price;

    @NotEmpty
    private int quantity;

    public Shirt(){}

    public Shirt(int id, String size, String color, String description, double price, int quantity) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shirt shirt = (Shirt) o;
        return id == shirt.id && Double.compare(shirt.price, price) == 0 && quantity == shirt.quantity && Objects.equals(size, shirt.size) && Objects.equals(color, shirt.color) && Objects.equals(description, shirt.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
