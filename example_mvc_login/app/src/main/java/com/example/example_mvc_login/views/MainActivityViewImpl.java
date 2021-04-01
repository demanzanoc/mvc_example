package com.example.example_mvc_login.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.example_mvc_login.R;
import com.example.example_mvc_login.interfaces.MainActivityPresenter;
import com.example.example_mvc_login.interfaces.MainActivityView;
import com.example.example_mvc_login.presenters.MainActivityPresenterImpl;

public class MainActivityViewImpl extends AppCompatActivity implements MainActivityView {

    EditText etSetUser;
    EditText etSetPassword;
    Button btSignIn;
    Button btSignUp;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        presenter = new MainActivityPresenterImpl(this);

    }

    private void initViews() {
        etSetUser = findViewById(R.id.etSetUser);
        etSetPassword = findViewById(R.id.etSetPassword);
        btSignIn = findViewById(R.id.btSignIn);
        btSignUp = findViewById(R.id.btSignUp);
    }
}
