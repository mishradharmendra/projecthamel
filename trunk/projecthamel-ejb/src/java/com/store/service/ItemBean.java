/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.service;

import com.store.entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rosharma
 */
@Stateless
public class ItemBean implements ItemRemote {

    @PersistenceContext
    EntityManager em;

    public void addItem(Item item) {
        em.persist(item);
    }

    public void removeItem(int itemID) {
        em.remove(em.merge((Item) em.find(Item.class, itemID)));
    }

    public Item findItem(int barcode) {
        try{
        Query query = em.createQuery("SELECT i FROM Item i WHERE i.barcode = ?1");
        query.setParameter(1, barcode);
        return (Item) query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }        
    }

    public List<Item> findAllItems() {
        return em.createNamedQuery("findAllItems").getResultList();
    }

    public Item updateItem(int itemID, String name, int quantity, double price, int barcode,
            int minQuantity, String image, int itemsToOrder, double shippingCost) {
        Item item = (Item) em.find(Item.class, itemID);
        item.setName(name);
        item.setBarcode(barcode);
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setMinQuantity(minQuantity);
        item.setImage(image);
        item.setItemsToOrder(itemsToOrder);
        item.setShippingCost(shippingCost);
        em.merge(item);
        return item;
    }
   
}
