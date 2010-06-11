/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.store.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author rosharma
 */
@Entity
@NamedQuery(
name = "findAllItems",
query = "SELECT c FROM Item c")
public class Item implements Serializable {
    
    private String name;
    private int quantity;
    private double price;
    private int barcode;
    private int minQuantity;
    private String image;
    private int itemsToOrder;
    private int shippingCost;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


       /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the barcode
     */
    public int getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the minQuantity
     */
    public int getMinQuantity() {
        return minQuantity;
    }

    /**
     * @param minQuantity the minQuantity to set
     */
    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the itemsToOrder
     */
    public int getItemsToOrder() {
        return itemsToOrder;
    }

    /**
     * @param itemsToOrder the itemsToOrder to set
     */
    public void setItemsToOrder(int itemsToOrder) {
        this.itemsToOrder = itemsToOrder;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.store.entities.Item[id=" + id + "]";
    }

    /**
     * @return the shippingCost
     */
    public int getShippingCost() {
        return shippingCost;
    }

    /**
     * @param shippingCost the shippingCost to set
     */
    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

}
