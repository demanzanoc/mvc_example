package com.example.example_mvc_login.interactors;

import com.example.example_mvc_login.interfaces.MainActivityInteractor;
import com.example.example_mvc_login.interfaces.MainActivityPresenter;
import com.example.example_mvc_login.presenters.MainActivityPresenterImpl;

public class MainActivityInteractorImpl implements MainActivityInteractor {

    private MainActivityPresenter presenter;

    public MainActivityInteractorImpl(MainActivityPresenterImpl presenter) {
        this.presenter = presenter;
    }
}
