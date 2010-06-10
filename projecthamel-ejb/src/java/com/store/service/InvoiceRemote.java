/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.store.service;



import com.store.entities.Invoice;
import javax.ejb.Remote;

/**
 *
 * @author rosharma
 */
@Remote
public interface InvoiceRemote {

    
    void addItem(int barcode);
    void removeItem(int barcode);
    void saveInvoice();
    void cancelInvoice();
    void addCustomer(int customerID);    
    int getCartTotal();
    Invoice getInvoice();
}
