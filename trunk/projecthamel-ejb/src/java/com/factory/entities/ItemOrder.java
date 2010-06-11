/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.factory.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rosharma
 */
@Entity
public class ItemOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int barcode;
    private int companyID;
    private int companyBranchID;
    private int totalItemsToOrder;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(object instanceof ItemOrder)) {
            return false;
        }
        ItemOrder other = (ItemOrder) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.factory.entities.Shipping[id=" + id + "]";
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
     * @return the companyID
     */
    public int getCompanyID() {
        return companyID;
    }

    /**
     * @param companyID the companyID to set
     */
    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    /**
     * @return the companyBranchID
     */
    public int getCompanyBranchID() {
        return companyBranchID;
    }

    /**
     * @param companyBranchID the companyBranchID to set
     */
    public void setCompanyBranchID(int companyBranchID) {
        this.companyBranchID = companyBranchID;
    }

    /**
     * @return the totalItemsToOrder
     */
    public int getTotalItemsToOrder() {
        return totalItemsToOrder;
    }

    /**
     * @param totalItemsToOrder the totalItemsToOrder to set
     */
    public void setTotalItemsToOrder(int totalItemsToOrder) {
        this.totalItemsToOrder = totalItemsToOrder;
    }

}
