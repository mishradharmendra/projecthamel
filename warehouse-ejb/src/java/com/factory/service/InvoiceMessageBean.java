/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factory.service;

import com.factory.entities.ItemOrder;
import java.util.ArrayList;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rosharma
 */
@MessageDriven(mappedName = "jms/InvoiceQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class InvoiceMessageBean implements MessageListener {

    @PersistenceContext
    EntityManager em;

    public InvoiceMessageBean() {
    }

    public void onMessage(Message message) {
        try {            
            ObjectMessage objectMessage = (ObjectMessage) message;
            ArrayList list = (ArrayList)objectMessage.getObject();
            ItemOrder itemOrder = new ItemOrder();
            itemOrder.setBarcode(Integer.parseInt(list.get(0).toString()));
            itemOrder.setTotalItemsToOrder(Integer.parseInt(list.get(1).toString()));
            itemOrder.setCompanyID(19284);
            em.persist(itemOrder);
        } catch (JMSException jmse) {
            jmse.printStackTrace();
        }
    }
}
