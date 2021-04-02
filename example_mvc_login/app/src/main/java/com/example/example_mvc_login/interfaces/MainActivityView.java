package com.example.example_mvc_login.interfaces;

import com.google.firebase.auth.FirebaseUser;

public interface MainActivityView {

    void onSuccessSignUp(FirebaseUser user);

    void onFailureSignUp(String message);

}
