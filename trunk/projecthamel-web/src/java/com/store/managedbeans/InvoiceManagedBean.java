/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.managedbeans;

import com.store.service.InvoiceRemote;
import com.store.util.Message;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author trana
 */
public class InvoiceManagedBean {

    @EJB
    private InvoiceRemote invoiceService;
    private Message message;

    public String addItem() {
        int barcode = Integer.parseInt(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("currentItemBarcode"));
        getInvoiceService().addItem(barcode);
        return "home";
    }

    public String showCart() {
        return "cart";
    }

    public String removeItem() {
        int barcode = Integer.parseInt(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("currentItemBarcode"));
        getInvoiceService().removeItem(barcode);
        return "cart";
    }

    public String checkout() {
        if (invoiceService.getCartTotal() == 0) {
            message.addErrorMessage("There is no item in the cart to checkout!");
            return "cart";
        }
        CustomerManagedBean cmb = (CustomerManagedBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("CustomerManagedBean");

        if (cmb.getIsLoggedIn().equals("Login")) {
            message.addErrorMessage("You need to login first.");
            return "login";
        }
        try {
            invoiceService.saveInvoice();
        } catch (Exception e) {
        }
        message.addSuccessMessage("You have sucessfully purchased!");
        return "home";

    }

    public String clearCart() {
        if (invoiceService.getCartTotal() == 0) {
            message.addErrorMessage("Cart is empty!");
            return "cart";
        }
        try {
            invoiceService.cancelInvoice();
        } catch (Exception e) {
        }
        message.addSuccessMessage("Cart is now empty!");
        return "home";

    }

    /**
     * @return the invoiceService
     */
    public InvoiceRemote getInvoiceService() {
        return invoiceService;
    }

    /**
     * @param invoiceService the invoiceService to set
     */
    public void setInvoiceService(InvoiceRemote invoiceService) {
        this.invoiceService = invoiceService;
    }
}
