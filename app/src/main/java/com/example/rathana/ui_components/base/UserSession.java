package com.example.rathana.ui_components.base;

import com.example.rathana.ui_components.enitiy.User;

/**
 * Created by RATHANA on 11/26/2017.
 */

public class UserSession {

    static User user;
    private UserSession(){}
    public static User getInstance() {
        if (null == user) {
            user = new User();
            user.setName("");
            user.setPassword("");
        }
        return user;
    }

    public static void logout() {
        user.setPassword("");
        user.setName("");
    }
}
