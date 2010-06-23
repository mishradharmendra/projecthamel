/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.service;

import com.store.entities.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rosharma
 */
@Stateless
public class OrderBean implements OrderRemote {

    @PersistenceContext
    EntityManager em;

    public void addOrder(Orders order) {
        em.persist(order);
    }

    public List<Orders> getOrders() {
        return (List<Orders>) em.createQuery("SELECT o FROM order o").getResultList();
    }

     public List<Orders> getOrders(int customerID) {
         return (List<Orders>) em.createQuery("SELECT o FROM order o WHERE o.customerID=?1").setParameter(1, customerID).getResultList();
    }
}
