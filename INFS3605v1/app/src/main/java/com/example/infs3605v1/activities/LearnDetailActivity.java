package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.infs3605v1.R;

public class LearnDetailActivity extends AppCompatActivity {

    ConstraintLayout learnDetailHeader;
    TextView learnDetailTitle;
    TextView learnDetailBody;
    Intent intent;
    String learnDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_detail);

        learnDetailHeader = findViewById(R.id.learnDetailHeader);
        learnDetailTitle = learnDetailHeader.findViewById(R.id.learnDetailTitle);
        learnDetailBody = findViewById(R.id.learnDetailBody);

        intent = getIntent();
        learnDetail = intent.getStringExtra("learnDetail");
        learnDetailTitle.setText(learnDetail);


    }
}
