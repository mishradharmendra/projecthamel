/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.service;

import com.factory.entities.Shipping;
import java.sql.SQLException;
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
            System.out.println("Inside onmessage......................"+message);
            ObjectMessage objectMessage = (ObjectMessage) message;
            int barcode = (Integer) objectMessage.getObject();
            Shipping ship = new Shipping();
            ship.setBarcode(barcode);
            em.persist(ship);
        } catch (JMSException jmse) {
            jmse.printStackTrace();
        }
    }
}
