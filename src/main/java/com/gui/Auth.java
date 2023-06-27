package com.gui;

import java.math.BigInteger;
//Singleton
public class Auth {
    private static BigInteger authUserId;

    private static Auth auth_instance = null;

    private Auth(){}

    public static Auth getInstance(){
        if (auth_instance == null){
            auth_instance = new Auth();
        }
        return auth_instance;
    }

    public static void setAuthUserId(BigInteger id){
        authUserId = id;
    }
    public static BigInteger getAuthUserId(){
        return authUserId;
    }
}
