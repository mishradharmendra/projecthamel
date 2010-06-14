/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.store.service;

import com.store.entities.Customer;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rosharma
 */
@Remote
public interface CustomerRemote {

    void addCustomer(Customer customer);
    void removeCustomer(int customerID);
    List<Customer> findAllCustomer();
    Customer findCustomer(int customerID);
    void updateCustomer(int customerID, String name, String email, String username,
            String password,String street, String city, String state, int zip, String phone);
    int findCustomerByUsername(String username);
    Customer findCustomerByUsernamePassword(String username, String password);
    
}
