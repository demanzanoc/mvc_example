package com.example.example_mvc_login.presenters;

import com.example.example_mvc_login.interactors.MainActivityInteractorImpl;
import com.example.example_mvc_login.interfaces.MainActivityInteractor;
import com.example.example_mvc_login.interfaces.MainActivityPresenter;
import com.example.example_mvc_login.interfaces.MainActivityView;
import com.example.example_mvc_login.views.MainActivityViewImpl;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView view;
    private MainActivityInteractor interactor;

    public MainActivityPresenterImpl(MainActivityViewImpl view) {
        this.view = view;
        this.interactor = new MainActivityInteractorImpl(this);
    }

    @Override
    public void createUser(String email, String password) {
        interactor.createUser(email, password);
    }

    @Override
    public void signIn(String email, String password) {
        interactor.signIn(email, password);
    }

    @Override
    public void onSuccessSignUp(FirebaseUser user) {
        if (view != null)
            view.onSuccessSignUp(user);
    }

    @Override
    public void onFailureSignUp(String message) {
        if (view != null)
            view.onFailureSignUp(message);
    }

    @Override
    public void onSuccessSignIn(FirebaseUser user) {
        if (view != null)
            view.onSuccessSignIn(user);
    }

    @Override
    public void onFailureSignIn(String message) {
        if (view != null)
            view.onFailureSignIn(message);
    }
}
