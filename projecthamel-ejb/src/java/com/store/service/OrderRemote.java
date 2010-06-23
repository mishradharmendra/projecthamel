/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.store.service;

import com.store.entities.Orders;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rosharma
 */
@Remote
public interface OrderRemote {
    
    void addOrder(Orders order);
    List<Orders> getOrders();
    List<Orders> getOrders(int customerID);
}
