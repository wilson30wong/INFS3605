package com.example.infs3605v1.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
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

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout loginElement;
    EditText username;
    EditText password;
    Button loginButton;
    TextView forgotPassword;
    TextView signUp;
    Intent intent;
    AppDatabase db;
    User user;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginElement = findViewById(R.id.loginElement);
        username = loginElement.findViewById(R.id.username);
        password = loginElement.findViewById(R.id.password);
        loginButton = loginElement.findViewById(R.id.loginButton);
        forgotPassword = loginElement.findViewById(R.id.forgotPassword);
        signUp = loginElement.findViewById(R.id.signUp);
        db = AppDatabase.getInstance(getApplicationContext());


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAuthenticator();
            }
        });

        password.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    loginAuthenticator();
                }
                return false;
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.userDao().deleteAll();
                intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SignUpActvity.class);
                startActivity(intent);
            }
        });

    }

    private void loginAuthenticator(){
        user = db.userDao().findUserByUsername(username.getText().toString().toLowerCase());
        if(user == null){
            toast = Toast.makeText(getApplicationContext(), "Username does not exist.", Toast.LENGTH_LONG);
            toastConfiguration(toast);
            toast.show();
        } else if (!(password.getText().toString().equals(user.getPassword()))){
            toast = Toast.makeText(getApplicationContext(), "Password is incorrect.", Toast.LENGTH_LONG);
            toastConfiguration(toast);
            toast.show();
        } else{
            intent = new Intent(getApplicationContext(), HomeActivity.class);
            finish();
            startActivity(intent);
        }
    }

    private Toast toastConfiguration(Toast toast){
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);

        TextView textView = (TextView) view.findViewById(android.R.id.message);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(15);

        return toast;
    }

}
