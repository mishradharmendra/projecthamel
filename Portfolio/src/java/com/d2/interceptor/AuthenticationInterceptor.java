/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;
import com.d2.domain.User;
import com.d2.utils.UserAware;
import com.opensymphony.xwork2.Action;

/**
 *
 * @author trana
 */
public class AuthenticationInterceptor implements Interceptor {

    public void destroy() {
    }

    public void init() {
    }

    public String intercept(ActionInvocation actionInvocation ) throws Exception {

		/* Get the session map from the invocation context ( the ActionContext actually )
		 * and check for the user object.  Note, we are not going directly to the Servlet
		 * API's session object, even though this is most likely the map being returned
		 * by this code; we need to keep our Struts 2 components cleanly separated from the
		 * Servlet API so that our testing can be as simple as faking a map, rather than
		 * faking Servlet API objects.
		 */
		Map session = actionInvocation.getInvocationContext().getSession();

		/* As a side effect of the structure of this sample application, we might have
		 * stale tokens.  By stale, we mean that a perhaps a user logged in under a different
		 * version of this app, then came to this version.  This would mean that the
		 * User token stored in the session would belong to a different package, as per
		 * our chapter based package structure.  We will handle this by purging any stale
		 * tokens before doing the true work of this interceptor.
		 */
		purgeStaleTokens(session);

		User user = (User) session.get("user");

		/*
		 * If user doesn't exist return the LOGIN control string.  This will cause the
		 * execution of this action to stop and the request will return the globally defined
		 * login result.
		 */
		if (user == null) {
		    return Action.LOGIN;
		}


		/*
		 * If the user is logged in, get the action, inject the user, then continue the
		 * execution of this request by invoking the rest of the interceptor stack, and ultimately,
		 * the action.
		 */
		else {

		    Action action = ( Action ) actionInvocation.getAction();

		    if (action instanceof UserAware) {
		        ((UserAware)action).setUser(user);
		    }

		    /*
		     * We just return the control string from the invoke method.  If we wanted, we could hold the string for
		     * a few lines and do some post processing.  When we do return the string, execution climbs back out of the
		     * recursive hole, through the higher up interceptors, and finally arrives back at the actionInvocation itself,
		     * who then fires the result based upon the result string returned.
		     */
		    System.out.println("Logged in: interceptor");
		    return actionInvocation.invoke();
		}

	}

	private void purgeStaleTokens (Map session ){

		/* Due to the structure of our sample app, we might have a User token of a
		 * different type stored, i.e. a User set into the session scope by one of
		 * the other versions of the app, a different chapter package's User.
		 *
		 * If the User token is not of the right type, we'll just throw it away.
		 * A sort of forced logout when switching between versions of the application.
		 */

		Object userToken = session.get("user");
		if ( !( userToken instanceof User ) ) session.remove ("user") ;

	}
}
