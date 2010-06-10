/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.service;

import com.store.entities.Customer;
import com.store.entities.Invoice;
import com.store.entities.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Remove;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 *
 * @author rosharma
 */
@Stateless
public class InvoiceBean implements InvoiceRemote {

    private Invoice invoice = new Invoice();
    @EJB
    private ItemRemote itemService;
    @EJB
    private CustomerRemote customerService;
    @PersistenceContext
    EntityManager em;
    @Resource(name = "jms/InvoiceQueueFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "jms/InvoiceQueue")
    private Destination destination;
    private int cartTotal;

    public void addItem(int barcode) {
        Item it = new Item();
        it = (Item) itemService.findItem(barcode);
        if (it.getQuantity() < 1) {
            System.out.println("No item available..........");
        } else {
            it.setQuantity(it.getQuantity() - 1);
            it = (Item) itemService.updateItem(it.getId(), it.getName(), it.getQuantity(), it.getPrice(), it.getBarcode(), it.getMinQuantity(), it.getImage());
            if(getInvoice().getItems()==null){
                List<Item> items = new ArrayList<Item>();
                items.add(it);
                getInvoice().setItems(items);
                this.setCartTotal(1);
            }else{
                getInvoice().getItems().add(it);
                this.setCartTotal(this.getCartTotal()+1);
            }
            getInvoice().setTotalCost(it.getPrice()+getInvoice().getTotalCost());
        }

    }

    public void removeItem(int barcode) {
        Item it = itemService.findItem(barcode);
        it.setQuantity(it.getQuantity() + 1);
        itemService.updateItem(it.getId(), it.getName(), it.getQuantity(), it.getPrice(), it.getBarcode(), it.getMinQuantity(), it.getImage());
        getInvoice().getItems().remove(it);
        getInvoice().setTotalCost(getInvoice().getTotalCost()- it.getPrice());
        this.setCartTotal(this.getCartTotal()-1);
    }

    @Remove
    public void saveInvoice() {
        em.persist(getInvoice());
        for (Item i : getInvoice().getItems()) {
            Item it = new Item();
            it = itemService.findItem(i.getBarcode());
            if (it.getQuantity() <= it.getMinQuantity()) {

                try {
                    Connection connection = connectionFactory.createConnection();
                    Session session = connection.createSession(true,
                            Session.AUTO_ACKNOWLEDGE);
                    MessageProducer producer = session.createProducer(destination);
                    ObjectMessage message = session.createObjectMessage();
                    message.setObject(it.getBarcode());
                    producer.send(message);
                    session.close();
                    connection.close();
                } catch (JMSException ex) {
                    Logger.getLogger(InvoiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Remove
    public void cancelInvoice() {
        setInvoice(null);
    }

    public void addCustomer(int customerID) {

        Customer cust = new Customer();
        cust = (Customer) customerService.findCustomer(customerID);
        System.out.println(cust.getEmail());
        getInvoice().setCustomer(cust);
    }

    /**
     * @return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * @return the cartTotal
     */
    public int getCartTotal() {
        return cartTotal;
    }

    /**
     * @param cartTotal the cartTotal to set
     */
    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }
}


