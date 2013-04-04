package com.lucasia.tstf.jester.security;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * User: lucasia
 */
public class PasswordAuthenticator {

    public void setDefaultAuthenticator(final String user, final String password) {
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password.toCharArray());
            }
        });

    }
}
