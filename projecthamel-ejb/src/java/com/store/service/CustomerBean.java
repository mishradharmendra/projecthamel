/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.service;

import com.store.entities.Customer;
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
public class CustomerBean implements CustomerRemote {

    @PersistenceContext
    EntityManager em;

    public void addCustomer(Customer customer) {
        em.persist(customer);
    }

    public void removeCustomer(int customerID) {
        em.remove(em.merge((Customer) em.find(Customer.class, customerID)));
    }

    public List<Customer> findAllCustomer() {
        return (List<Customer>) em.createQuery("SELECT c FROM Customer c").getResultList();
    }

    public Customer findCustomer(int customerID) {
        return (Customer) em.find(Customer.class, customerID);
    }

    public int findCustomerByUsername(String username) {
        try {
            Object obj = em.createQuery("SELECT c FROM Customer c WHERE c.username =?1").setParameter(1, username).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;

    }

    public void updateCustomer(int customerID, String name, String email, String username, 
            String password,String street, String city, String state, int zip, String phone) {

        Customer cust = em.find(Customer.class, customerID);
        cust.setName(name);
        cust.setEmail(email);
        cust.setUsername(username);
        cust.setPassword(password);
        em.merge(cust);
    }

    public Customer findCustomerByUsernamePassword(String username, String password) {
        try{
            return (Customer) em.createQuery("SELECT c FROM Customer c WHERE c.username =:userName AND c.password =:pwd").setParameter("userName", username).setParameter("pwd", password).getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
}
