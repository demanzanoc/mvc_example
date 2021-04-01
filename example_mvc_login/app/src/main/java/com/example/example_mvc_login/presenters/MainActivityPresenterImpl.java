package com.example.example_mvc_login.presenters;

import com.example.example_mvc_login.interactors.MainActivityInteractorImpl;
import com.example.example_mvc_login.interfaces.MainActivityInteractor;
import com.example.example_mvc_login.interfaces.MainActivityPresenter;
import com.example.example_mvc_login.interfaces.MainActivityView;
import com.example.example_mvc_login.views.MainActivityViewImpl;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView view;
    private MainActivityInteractor interactor;

    public MainActivityPresenterImpl(MainActivityViewImpl view) {
        this.view = view;
        this.interactor = new MainActivityInteractorImpl(this);
    }
}
