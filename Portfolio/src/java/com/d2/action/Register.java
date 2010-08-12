/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.d2.action;

import com.d2.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PortfolioService;

/**
 *
 * @author trana
 */
public class Register extends ActionSupport {

    public String execute(){

		/*
		 * Create and move the data onto our application domain object, user.
		 */
		User user = new User();
		user.setPassword( getPassword() );
		user.setPortfolioName( getPortfolioName() );
		user.setUsername( getUsername() );

		getPortfolioService().createAccount( user );
		return SUCCESS;
	}


	/* JavaBeans Properties to Receive Request Parameters */

	private String username;
	private String password;
	private String portfolioName;

	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	/* Validateable Implmentation
	 *
	 * The validate method validates, invoked by the validation intercptor in
	 * the default stack, will validate the data already set on the action
	 * by the params interceptor, also in the default stack.
	 *
	 * If this method finds problems in validation it stores error messages via
	 * the methods exposed by the ValidationAware interface -- already implemented
	 * by the ActionSupport class that this action extends.  To complete the
	 * the validation process, the workflow interceptor fires next in the default
	 * stack.  It checks for error messages on the action, and if it finds them
	 * it diverts workflow back to the input page where the error messages are
	 * displayed to the user.  In this case, the execute method of the action
	 * will not be called because the workflow was diverted, due to validation
	 * problems, before execution reached the action itself.
	 *
	 * */

	public void validate(){

		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();

		/* Check that fields are not empty */
		if ( getPassword().length() == 0 ){
			addFieldError( "password", getText("password.required") );
		}
		if ( getUsername().length() == 0 ){
			addFieldError( "username", getText("username.required") );
		}
		if ( getPortfolioName().length() == 0  ){
			addFieldError( "portfolioName", getText( "portfolioName.required" ));
		}
		/* Make sure user doesn't already have an account */
		if ( ps.userExists(getUsername() ) ){
			addFieldError("username", getText( "user.exists"));
		}

	}

	/*
	 * Simple way to retrieve our business logic and data persistence
	 * object.  Late versions of the portfolio app will integrate with
	 * more sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService( ) 	{

		return new PortfolioService();

	}

}
