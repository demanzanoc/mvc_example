package com.example.example_mvc_login.interactors;

import androidx.annotation.NonNull;

import com.example.example_mvc_login.interfaces.MainActivityInteractor;
import com.example.example_mvc_login.interfaces.MainActivityPresenter;
import com.example.example_mvc_login.presenters.MainActivityPresenterImpl;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class MainActivityInteractorImpl implements MainActivityInteractor {

    private MainActivityPresenter presenter;
    private FirebaseAuth mAuth;

    public MainActivityInteractorImpl(MainActivityPresenterImpl presenter) {
        this.presenter = presenter;
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            presenter.onSuccessSignUp(mAuth.getCurrentUser());
                        } else {
                            presenter.onFailureSignUp("Error al crear el nuevo usuario!");
                        }
                    }
                });
    }

    @Override
    public void signIn(String email, String password) {

    }
}
