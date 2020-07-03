package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.infs3605v1.R;

public class LearnActivity extends AppCompatActivity {

    TextView learnElementTitle;

    LinearLayout learnButtonLayer1;
    Button learnButton1;
    Button learnButton2;
    LinearLayout learnButtonMessageLayer1;
    TextView learnButtonMessage1;
    TextView learnButtonMessage2;
    LinearLayout learnButtonLayer2;
    Button learnButton3;
    Button learnButton4;
    LinearLayout learnButtonMessageLayer2;
    TextView learnButtonMessage3;
    TextView learnButtonMessage4;
    Intent intent;
    String learnElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        learnElementTitle = findViewById(R.id.learnElementTitle);
        learnButtonLayer1 = findViewById(R.id.learnButtonLayer1);
        learnButton1 = learnButtonLayer1.findViewById(R.id.learnButton1);
        learnButton2 = learnButtonLayer1.findViewById(R.id.learnButton2);
        learnButtonMessageLayer1 = findViewById(R.id.learnButtonMessageLayer1);
        learnButtonMessage1 = learnButtonMessageLayer1.findViewById(R.id.learnButtonMessage1);
        learnButtonMessage2 = learnButtonMessageLayer1.findViewById(R.id.learnButtonMessage2);
        learnButtonLayer2 = findViewById(R.id.learnButtonLayer2);
        learnButton3 = learnButtonLayer2.findViewById(R.id.learnButton3);
        learnButton4 = learnButtonLayer2.findViewById(R.id.learnButton4);
        learnButtonMessageLayer2 = findViewById(R.id.learnButtonMessageLayer2);
        learnButtonMessage3 = learnButtonMessageLayer2.findViewById(R.id.learnButtonMessage3);
        learnButtonMessage4 = learnButtonMessageLayer2.findViewById(R.id.learnButtonMessage4);

        intent = getIntent();
        learnElement = intent.getStringExtra("learnElement");

        learnElementTitle.setText(learnElement);
        learnButtonMessage1.setText("What is " + learnElement +"?");
        learnButtonMessage3.setText("Manage " + learnElement);

        learnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
                intent.putExtra("learnDetail",learnButtonMessage1.getText().toString());
                startActivity(intent);
            }
        });
        learnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
                intent.putExtra("learnDetail",learnButtonMessage2.getText().toString());
                startActivity(intent);
            }
        });
        learnButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
                intent.putExtra("learnDetail",learnButtonMessage3.getText().toString());
                startActivity(intent);
            }
        });
        learnButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearnDetailActivity.class);
                intent.putExtra("learnDetail",learnButtonMessage4.getText().toString());
                startActivity(intent);
            }
        });

    }
}
