package com.room1.JGEBMA.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "sales_tax_rate")
public class SalesTaxRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Length(max = 2, min = 2)
    private String state;

    @NotNull
    private BigDecimal rate;

    public SalesTaxRate() {}

    public SalesTaxRate(int id, String state, BigDecimal rate) {
        this.id = id;
        this.state = state;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRate that = (SalesTaxRate) o;
        return id == that.id && Objects.equals(state, that.state) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, rate);
    }

    @Override
    public String toString() {
        return "SalesTaxRate{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
