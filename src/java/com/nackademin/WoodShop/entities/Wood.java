/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.WoodShop.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bamsen
 */
@Entity
@Table(name = "WOOD")
@NamedQuery(name = "findWoodList",
        query = "SELECT b FROM Wood b ORDER BY b.woodId")
public class Wood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private Integer woodId;
    private Double price;
    private String type;
    private Integer stock;

    public Wood() {
    }

    public Wood(Integer woodId, Double price, String type,
            Integer stock) {
        this.woodId = woodId;
        this.price = price;
        this.type = type;
        this.stock = stock;

    }

    public Integer getId() {
        return woodId;
    }

    public void setId(Integer woodId) {
        this.woodId = woodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (woodId != null ? woodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wood)) {
            return false;
        }
        Wood other = (Wood) object;
        return (this.woodId != null || other.woodId == null) && (this.woodId == null || this.woodId.equals(other.woodId));
    }

    @Override
    public String toString() {
        return "com.nackademin.WoodShop.entities.Wood[ id=" + woodId + " ]";
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
