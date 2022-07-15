package com.room1.demo.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "processing_fee")
public class ProcessingFee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Length(max =20, min = 1)
    @Column(name = "product_type")
    private String productType;

    private BigDecimal fee;

    public ProcessingFee(){}

    public ProcessingFee(int id, String productType, BigDecimal fee) {
        this.id = id;
        this.productType = productType;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return id == that.id && Objects.equals(productType, that.productType) && Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType, fee);
    }

    @Override
    public String toString() {
        return "ProcessingFee{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
