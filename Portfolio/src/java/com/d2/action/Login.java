/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2.action;

import com.d2.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PortfolioService;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author trana
 */
public class Login extends ActionSupport implements SessionAware {

    private String username;
    private String password;
    private Map session;

    public void validate() {
        /* Retrieve our simple portfolio service object. */
        PortfolioService ps = getPortfolioService();

        /* Check that fields are not empty */
        if (getPassword().length() == 0) {
            addFieldError("password", getText("password.required"));
        }
        if (getUsername().length() == 0) {
            addFieldError("username", getText("username.required"));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public String execute() {
        User newUuser = getPortfolioService().authenticateUser(getUsername(), getPassword());
        if (newUuser == null) {
            /* User not valid, return to input page. */
            addFieldError("username", getText("username.invalid"));
            return INPUT;
        } else {
            getSession().put("user", newUuser);
            return SUCCESS;
        }
    }


    /*
     * Simple way to retrieve our business logic and data peristence
     * object.  Late versions of the portfolio app will intergrate with
     * more sophisticated technologies for these services.
     */
    public PortfolioService getPortfolioService() {
        return new PortfolioService();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void setSession(Map session) {
        this.session = session;

    }

    /**
     * @return the session
     */
    public Map getSession() {
        return session;
    }
}
