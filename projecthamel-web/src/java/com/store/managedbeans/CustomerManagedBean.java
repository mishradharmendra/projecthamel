/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.managedbeans;

import com.store.entities.Customer;
import com.store.service.CustomerRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import com.store.util.Message;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author rosharma
 */
public class CustomerManagedBean {

    /** Creates a new instance of CustomerManagedBean */
    @EJB
    private CustomerRemote customerService;
    private Customer customer;
    private Customer lgCustomer;
    private List<Customer> customerList = null;
    private Message message;
    private String isLoggedIn;

    public CustomerManagedBean() {
        this.lgCustomer = new Customer();
        setIsLoggedIn("Login");
    }

    public String createCustomer() {
        this.customer = new Customer();
        return "customer_create";
    }

    public String editCustomer() {
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("currentCustomerID"));
        customer = customerService.findCustomer(id);
        return "customer_edit";
    }

    public String removeCustomer() {
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("currentCustomerID"));
        customerService.removeCustomer(id);
        return "customer_remove";
    }

    public String listCustomer() {
        return "customer_view";
    }

    public String edit() {
        try {
            customerService.updateCustomer(lgCustomer.getId(), lgCustomer.getName(), lgCustomer.getEmail(), lgCustomer.getUsername(), lgCustomer.getPassword());
            message.addSuccessMessage("Your account has been updated successfully.");
        } catch (Exception ex) {
            message.addErrorMessage(ex.getLocalizedMessage());
        }

        return "customer_view";
    }

    public String loginCustomer() {
        this.lgCustomer = new Customer();
        if (getIsLoggedIn().equals("Logout")) {
            setIsLoggedIn("Login");
            return "home";
        } else {
            return "login";
        }
    }

    public String create() {       
        FacesContext context = FacesContext.getCurrentInstance();
        int count = customerService.findCustomerByUsername(customer.getUsername());
        if (count > 0) {
            //message.addErrorMessage("Username already exists.");
            FacesMessage msg = new FacesMessage();            
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            msg.setSummary("Username already exists");
            msg.setDetail("Username already exists");
            context.addMessage("signupForm:username", msg);
            return "customer_create";
        }
        try {
            customerService.addCustomer(customer);
            message.addSuccessMessage("Customer was successfully submitted.");
        } catch (Exception ex) {
            message.addErrorMessage(ex.getLocalizedMessage());
        }
        return "home";
    }

    public String validateLogin() {
        Customer newCustomer = customerService.findCustomerByUsernamePassword(lgCustomer.getUsername(), lgCustomer.getPassword());
        //this.lgCustomer = customerService.findCustomerByUsernamePassword(lgCustomer.getUsername(), lgCustomer.getPassword());
        if (newCustomer != null) {
            setLgCustomer(newCustomer);
            setIsLoggedIn("Logout");
            return "home";
        } else {
            message.addErrorMessage("Invalid Username or Password");
            return "login";
        }
    }

    public String viewAccount() {
        if (getIsLoggedIn().equals("Logout")) {
            return "my_account";
        } else {
            message.addErrorMessage("You need to login first.");
            this.lgCustomer = new Customer();
            return "login";
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the customerList
     */
    public List<Customer> getCustomerList() {
        return customerService.findAllCustomer();
    }

    /**
     * @param customerList the customerList to set
     */
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    /**
     * @return the lgCustomer
     */
    public Customer getLgCustomer() {
        return lgCustomer;
    }

    /**
     * @param lgCustomer the lgCustomer to set
     */
    public void setLgCustomer(Customer lgCustomer) {
        this.lgCustomer = lgCustomer;
    }

    /**
     * @return the isLoggedIn
     */
    public String getIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setIsLoggedIn(String isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
}
