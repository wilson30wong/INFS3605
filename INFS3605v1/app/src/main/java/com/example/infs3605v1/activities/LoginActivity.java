package com.example.infs3605v1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.User;
import com.example.infs3605v1.methods.Methods;

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout loginElement;
    EditText loginUsername;
    EditText loginPassword;
    Button loginButton;
    TextView loginForgotPassword;
    TextView loginSignUp;
    Toast toast;

    Intent intent;
    Methods methods;
    AppDatabase db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginElement = findViewById(R.id.loginElement);
        loginUsername = loginElement.findViewById(R.id.loginUsername);
        loginPassword = loginElement.findViewById(R.id.loginPassword);
        loginButton = loginElement.findViewById(R.id.loginButton);
        loginForgotPassword = loginElement.findViewById(R.id.loginForgotPassword);
        loginSignUp = loginElement.findViewById(R.id.loginSignUp);

        db = AppDatabase.getInstance(getApplicationContext());
        methods = new Methods(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAuthenticator();
            }
        });

        loginPassword.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    loginAuthenticator();
                }
                return false;
            }
        });

        loginForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(getApplicationContext(), "Coming Soon!", Toast.LENGTH_LONG);
                methods.toastConfiguration(toast);
                toast.show();

//                start forgot password page which is not currently working
//                intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
//                startActivity(intent);
            }
        });

        loginSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SignUpActvity.class);
                startActivity(intent);
            }
        });

    }

    private void loginAuthenticator() {
        user = db.userDao().findUserByUsername(loginUsername.getText().toString().toLowerCase());
        if (user == null) {
            toast = Toast.makeText(getApplicationContext(), "Username does not exist.", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        } else if (!(loginPassword.getText().toString().equals(user.getPassword()))) {
            toast = Toast.makeText(getApplicationContext(), "Password is incorrect.", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        } else {
            intent = new Intent(getApplicationContext(), HomeActivity.class);
            intent.putExtra("username", loginUsername.getText().toString().toLowerCase());
            finish();
            startActivity(intent);
        }
    }

}
