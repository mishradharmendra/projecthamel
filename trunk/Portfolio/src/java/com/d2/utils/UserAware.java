/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.d2.utils;

import com.d2.domain.User;

/**
 *
 * @author trana
 */

    /*
 * Simple interface for actions that want to have the user object injected.
 */

public interface UserAware {

	public void setUser(User user );

}


