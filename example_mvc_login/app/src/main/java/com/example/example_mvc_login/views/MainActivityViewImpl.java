package com.example.example_mvc_login.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.example_mvc_login.R;
import com.example.example_mvc_login.interfaces.MainActivityPresenter;
import com.example.example_mvc_login.interfaces.MainActivityView;
import com.example.example_mvc_login.presenters.MainActivityPresenterImpl;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewImpl extends AppCompatActivity implements
        View.OnClickListener, MainActivityView {

    EditText etUser;
    EditText etPassword;
    Button btSignIn;
    Button btSignUp;
    private MainActivityPresenter presenter;
    private String email = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        presenter = new MainActivityPresenterImpl(this);
        btSignUp.setOnClickListener(this);
        btSignIn.setOnClickListener(this);
    }

    private void initViews() {
        etUser = findViewById(R.id.etSetUser);
        etPassword = findViewById(R.id.etSetPassword);
        btSignIn = findViewById(R.id.btSignIn);
        btSignUp = findViewById(R.id.btSignUp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSignUp:
                getCredentials();
                signUp();
                break;
            case R.id.btSignIn:
                getCredentials();
                logIn();
                break;
            default:
                break;
        }
    }

    private void getCredentials() {
        email = etUser.getText().toString();
        password = etPassword.getText().toString();
    }

    private void signUp() {
        presenter.createUser(email, password);
    }

    private void logIn() {
        presenter.signIn(email, password);
    }

    @Override
    public void onSuccessSignUp(FirebaseUser user) {
        Toast.makeText(this, "Bienvenido " + user.getEmail() +
                ", Ahora puede iniciar sesión", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureSignUp(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}
