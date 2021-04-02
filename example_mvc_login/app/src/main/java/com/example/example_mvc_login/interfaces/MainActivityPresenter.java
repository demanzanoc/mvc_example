package com.example.example_mvc_login.interfaces;

import com.google.firebase.auth.FirebaseUser;

public interface MainActivityPresenter {

    void createUser(String email, String password);

    void signIn(String email, String password);

    void onSuccessSignUp(FirebaseUser user) ;

    void onFailureSignUp(String message);

}
