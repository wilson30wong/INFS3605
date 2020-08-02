package com.example.infs3605v1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.infs3605v1.R;
import com.example.infs3605v1.methods.Methods;

public class LearnActivity extends AppCompatActivity {

    TextView learnElementTitle;

    LinearLayout learnButtonLayer1;
    ConstraintLayout learnPanel1;
    ConstraintLayout learnPanel2;
    LinearLayout learnButtonMessageLayer1;
    TextView learnButtonMessage1;
    TextView learnButtonMessage2;
    LinearLayout learnButtonLayer2;
    ConstraintLayout learnPanel3;
    ConstraintLayout learnPanel4;
    LinearLayout learnButtonMessageLayer2;
    TextView learnButtonMessage3;
    TextView learnButtonMessage4;
    Toast toast;

    Intent intent;
    String learnElement;
    Methods methods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        learnElementTitle = findViewById(R.id.learnElementTitle);
        learnButtonLayer1 = findViewById(R.id.learnButtonLayer1);
        learnPanel1 = learnButtonLayer1.findViewById(R.id.learnPanel1);
        learnPanel2 = learnButtonLayer1.findViewById(R.id.learnPanel2);
        learnButtonMessageLayer1 = findViewById(R.id.learnButtonMessageLayer1);
        learnButtonMessage1 = learnButtonMessageLayer1.findViewById(R.id.learnButtonMessage1);
        learnButtonMessage2 = learnButtonMessageLayer1.findViewById(R.id.learnButtonMessage2);
        learnButtonLayer2 = findViewById(R.id.learnButtonLayer2);
        learnPanel3 = learnButtonLayer2.findViewById(R.id.learnPanel3);
        learnPanel4 = learnButtonLayer2.findViewById(R.id.learnPanel4);
        learnButtonMessageLayer2 = findViewById(R.id.learnButtonMessageLayer2);
        learnButtonMessage3 = learnButtonMessageLayer2.findViewById(R.id.learnButtonMessage3);
        learnButtonMessage4 = learnButtonMessageLayer2.findViewById(R.id.learnButtonMessage4);

        intent = getIntent();
        methods = new Methods(this);
        learnElement = intent.getStringExtra("learnElement");
        learnElementTitle.setText(learnElement);
        learnButtonMessage1.setText("What is " + learnElement +"?");
        learnButtonMessage3.setText("Manage " + learnElement);

        learnPanel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
                intent.putExtra("learnDetail", learnElement);
                intent.putExtra("learnDetailPanel","whatIs");
                startActivity(intent);
            }
        });
        learnPanel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
                intent.putExtra("learnDetail", learnElement);
                intent.putExtra("learnDetailPanel","signsAndSymptoms");
                startActivity(intent);
            }
        });
        learnPanel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
                intent.putExtra("learnDetail", learnElement);
                intent.putExtra("learnDetailPanel","manage");
                startActivity(intent);
            }
        });
        learnPanel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(getApplicationContext(), "Coming Soon!", Toast.LENGTH_LONG);
                methods.toastConfiguration(toast);
                toast.show();

//                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
//                intent.putExtra("learnDetail", learnElement);
//                intent.putExtra("learnDetailPanel","stories");
//                startActivity(intent);
            }
        });

    }
}
