/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.store.service;

import com.store.entities.Item;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rosharma
 */
@Remote
public interface ItemRemote {
    void addItem(Item item);
    void removeItem(int itemID);
    Item findItem(int barcode);
    List<Item> findAllItems();
    Item updateItem(int itemID, String name, int quantity, double price, int barcode, int minQuantity, String image);
}
