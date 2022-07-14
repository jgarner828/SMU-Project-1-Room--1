package com.room1.demo.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Game {

    @NotEmpty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private int gameId;

    @NotEmpty
    private String title;

    @NotEmpty
    @Column(name = "esrb_rating")
    @Length(max = 50, min = 1)
    private int esrbRating;

    @NotEmpty
    @Length(max = 255, min = 1)
    private String description;

    @NotEmpty
   private BigDecimal price;

    @NotEmpty
    @Length(max = 50, min = 1)
    private String studio;

    @NotEmpty
    private int quantity;

    public Game(){}

    public Game(int gameId, String title, int esrbRating, String description, BigDecimal price, String studio, int quantity) {
        this.gameId = gameId;
        this.title = title;
        this.esrbRating = esrbRating;
        this.description = description;
        this.price = price;
        this.studio = studio;
        this.quantity = quantity;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(int esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        Game game = (Game) o;
        return gameId == game.gameId && esrbRating == game.esrbRating && quantity == game.quantity && Objects.equals(title, game.title) && Objects.equals(description, game.description) && Objects.equals(price, game.price) && Objects.equals(studio, game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, esrbRating, description, price, studio, quantity);
    }
}
