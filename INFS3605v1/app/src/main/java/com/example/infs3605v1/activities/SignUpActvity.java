package com.example.infs3605v1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.User;
import com.example.infs3605v1.methods.Methods;

public class SignUpActvity extends AppCompatActivity {

    ConstraintLayout signUpElement;
    EditText signUpUsername;
    EditText signUpPassword;
    CheckBox signUpTOS;
    Button signUpButton;
    TextView signUpReturnSignIn;

    Toast toast;
    Intent intent;
    AppDatabase db;
    User user;
    Methods methods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpElement = findViewById(R.id.signUpElement);
        signUpUsername = signUpElement.findViewById(R.id.signUpUsername);
        signUpPassword = signUpElement.findViewById(R.id.signUpPassword);
        signUpTOS = signUpElement.findViewById(R.id.signUpTOS);
        signUpButton = signUpElement.findViewById(R.id.signUpButton);
        signUpReturnSignIn = signUpElement.findViewById(R.id.signUpReturnSignIn);

        db = AppDatabase.getInstance(getApplicationContext());
        methods = new Methods(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountCreationAuthenticator();
            }
        });

        signUpPassword.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    accountCreationAuthenticator();
                }
                return false;
            }
        });

        signUpReturnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void accountCreationAuthenticator(){
        if (signUpUsername.length() < 5) {
            toast = Toast.makeText(getApplicationContext(), "Username must be 5 characters or longer.", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        } else if (signUpUsername.length() > 19) {
            toast = Toast.makeText(getApplicationContext(), "Username must be 20 characters or shorter.", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        } else if (db.userDao().findUserByUsername(signUpUsername.getText().toString().toLowerCase()) != null) {
            toast = Toast.makeText(getApplicationContext(), "Username already exists.", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        } else if (signUpPassword.length() < 8) {
            toast = Toast.makeText(getApplicationContext(), "Password must be longer than 8 characters", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        } else if (!(signUpTOS.isChecked())) {
            toast = Toast.makeText(getApplicationContext(), "To make an account, you must agree to the ToS and Privacy Policy.", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        } else {
            user = new User(signUpUsername.getText().toString().toLowerCase(), signUpPassword.getText().toString().toLowerCase());
            db.userDao().insert(user);
            intent = new Intent(getApplicationContext(), LoginActivity.class);
            finish();
            startActivity(intent);
        }
    }

}
