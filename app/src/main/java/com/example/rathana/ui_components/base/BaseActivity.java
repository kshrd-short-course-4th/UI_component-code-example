package com.example.rathana.ui_components.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.rathana.ui_components.LoginActivity;
import com.example.rathana.ui_components.MainActivity;
import com.example.rathana.ui_components.enitiy.User;

/**
 * Created by RATHANA on 11/26/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public static User userSession;
    /*static{
        userSession =new User("","");
       *//* userMemory.setName();
        userMemory.setPassword();*//*
    }*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // userSession=new User("","");
    }
    public void checkUserSession(){
        if(UserSession.getInstance().getName().equals("") && UserSession.getInstance().getPassword().equals("")){
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }
    public abstract void showMessageError();
}
