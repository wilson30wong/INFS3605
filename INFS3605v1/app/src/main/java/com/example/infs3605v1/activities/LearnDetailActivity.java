package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Learn;

public class LearnDetailActivity extends AppCompatActivity {

    ConstraintLayout learnDetailHeader;
    TextView learnDetailTitle;
    TextView learnDetailBody;

    Intent intent;
    String learnDetail;
    String learnDetailPanel;
    Learn learn;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_detail);

        learnDetailHeader = findViewById(R.id.learnDetailHeader);
        learnDetailTitle = learnDetailHeader.findViewById(R.id.learnDetailTitle);
        learnDetailBody = findViewById(R.id.learnDetailBody);
        db = AppDatabase.getInstance(getApplicationContext());

        intent = getIntent();
        learnDetail = intent.getStringExtra("learnDetail");
        learnDetailPanel = intent.getStringExtra("learnDetailPanel");
        learn = db.learnDao().findLearnByName(learnDetail);
        if(learnDetailPanel.equals("whatIs")){
            learnDetailTitle.setText("What is " + learnDetail + "?");
            learnDetailBody.setText(learn.getWhatIs());
        } else if (learnDetailPanel.equals("signsAndSymptoms")){
            learnDetailTitle.setText("Signs and Symptoms");
            learnDetailBody.setText(learn.getSignsAndSymptoms());
        } else if (learnDetailPanel.equals("manage")){
            learnDetailTitle.setText("Manage " + learnDetail);
            learnDetailBody.setText(learn.getManage());
        } else if (learnDetailPanel.equals("stories")){
            learnDetailTitle.setText("Stories");
            learnDetailBody.setText(learn.getStories());
        }
    }
}
