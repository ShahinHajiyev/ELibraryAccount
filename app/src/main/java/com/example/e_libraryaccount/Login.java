package com.example.e_libraryaccount;

import android.widget.Toast;

public class Login {
    private String login = "Shahin";
    private String pass = "12345";


    public boolean isLog(User user){
        boolean log = false;
        if (login.equals(user.getUsername()) && pass.equals(user.getPassword())){
            log =  true;
        }

        return log;
    }

}
