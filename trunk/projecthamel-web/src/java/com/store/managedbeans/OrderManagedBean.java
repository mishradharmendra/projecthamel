/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.managedbeans;

import com.store.entities.Orders;
import com.store.service.OrderRemote;
import com.store.util.EmailSender;
import com.store.util.Message;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

/**
 *
 * @author rosharma
 */
public class OrderManagedBean {

    @EJB
    private OrderRemote orderService;
    Orders order;
    private Message message;
    private EmailSender emailSender;

    public String confirm() throws IOException, MessagingException {
        this.order = new Orders();
        CustomerManagedBean cmb = (CustomerManagedBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("CustomerManagedBean");
        InvoiceManagedBean imb = (InvoiceManagedBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("InvoiceManagedBean");

        order.setCity(cmb.getLgCustomer().getCity());
        order.setCustomerID(cmb.getLgCustomer().getId());
        order.setEmail(cmb.getLgCustomer().getEmail());
        order.setName(cmb.getLgCustomer().getName());
        order.setPhone(cmb.getLgCustomer().getPhone());
        order.setState(cmb.getLgCustomer().getState());
        order.setStreet(cmb.getLgCustomer().getStreet());
        order.setZip(cmb.getLgCustomer().getZip());

        emailSender = new EmailSender();
        try {
            imb.getInvoiceService().saveInvoice();
            emailSender.sendEmail(cmb.getLgCustomer().getEmail(), imb.getInvoiceService().getInvoice().getItems(), imb.getInvoiceService().getCartTotal());
            imb.clearCart();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            message.addErrorMessage("Purchase was unsuccessful!");
        }
        message.addSuccessMessage("You have sucessfully purchased!");
        return "home";
    }
}
