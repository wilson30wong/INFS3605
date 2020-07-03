package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.User;

public class SignUpActvity extends AppCompatActivity {

    ConstraintLayout signUpElement;
    EditText usernameSignUp;
    EditText passwordSignUp;
    CheckBox tosSignUp;
    Button signUpButton;
    TextView returnSignIn;
    Toast toast;
    Intent intent;
    AppDatabase db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpElement = findViewById(R.id.signUpElement);
        usernameSignUp = signUpElement.findViewById(R.id.usernameSignUp);
        passwordSignUp = signUpElement.findViewById(R.id.passwordSignUp);
        tosSignUp = signUpElement.findViewById(R.id.tosSignUp);
        signUpButton = signUpElement.findViewById(R.id.signUpButton);
        returnSignIn = signUpElement.findViewById(R.id.returnSignIn);
        db = AppDatabase.getInstance(getApplicationContext());

        System.out.println("Database has " + db.userDao().getAll().size() + " users");

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //account creation authenticator
                accountCreationAuthenticator();
            }
        });

        passwordSignUp.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    accountCreationAuthenticator();
                }
                return false;
            }
        });

        returnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void accountCreationAuthenticator(){
        if (usernameSignUp.length() < 5) {
            toast = Toast.makeText(getApplicationContext(), "Username must be longer than 5 characters.", Toast.LENGTH_LONG);
            toastConfiguration(toast);
            toast.show();
        } else if (db.userDao().findUserByUsername(usernameSignUp.getText().toString().toLowerCase()) != null) {
            toast = Toast.makeText(getApplicationContext(), "Username already exists.", Toast.LENGTH_LONG);
            toastConfiguration(toast);
            toast.show();
        } else if (passwordSignUp.length() < 8) {
            toast = Toast.makeText(getApplicationContext(), "Password must be longer than 8 characters", Toast.LENGTH_LONG);
            toastConfiguration(toast);
            toast.show();
        } else if (!(tosSignUp.isChecked())) {
            toast = Toast.makeText(getApplicationContext(), "To make an account, you must agree to the ToS and Privacy Policy.", Toast.LENGTH_LONG);
            toastConfiguration(toast);
            toast.show();
        } else {
            //enter account into account database
            user = new User(usernameSignUp.getText().toString().toLowerCase(), passwordSignUp.getText().toString().toLowerCase());
            db.userDao().insert(user);
            intent = new Intent(getApplicationContext(), LoginActivity.class);
            finish();
            startActivity(intent);
        }
    }

    private Toast toastConfiguration(Toast toast) {
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);

        TextView textView = (TextView) view.findViewById(android.R.id.message);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(15);

        return toast;
    }
}
