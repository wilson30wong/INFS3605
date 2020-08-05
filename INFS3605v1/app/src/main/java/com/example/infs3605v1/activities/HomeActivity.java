package com.example.infs3605v1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605v1.R;
import com.example.infs3605v1.adapters.LearnAdapter;
import com.example.infs3605v1.adapters.SoothingToolsAdapter;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.methods.Methods;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ConstraintLayout homeElement;
    TextView homeWelcomeTitle;
    RecyclerView.LayoutManager learnLayoutManager;
    RecyclerView recyclerViewLearn;
    RecyclerView.LayoutManager soothingToolsLayoutManager;
    RecyclerView recyclerViewSoothingTools;
    LinearLayout homeToolboxButtonLayer;
    ConstraintLayout homeHelplineButton;
    ConstraintLayout homeCovidButton;
    ConstraintLayout homeSettingsButton;
    Toast toast;

    Intent intent;
    AppDatabase db;
    int learnListSize;
    ArrayList<String> learnElementArrayList;
    ArrayList<String> sTElementArrayList;
    LearnAdapter learnAdapter;
    SoothingToolsAdapter soothingToolsAdapter;
    Methods methods;
    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeElement = findViewById(R.id.homeElement);
        homeWelcomeTitle = homeElement.findViewById(R.id.homeWelcomeTitle);
        homeToolboxButtonLayer = homeElement.findViewById(R.id.homeToolboxButtonLayer);
        homeHelplineButton = homeToolboxButtonLayer.findViewById(R.id.homeHelplineButton);
        homeCovidButton = homeToolboxButtonLayer.findViewById(R.id.homeCovidButton);
        homeSettingsButton = homeToolboxButtonLayer.findViewById(R.id.homeSettingsButton);

        db = AppDatabase.getInstance(getApplicationContext());
        methods = new Methods(this);
        intent = getIntent();
        if(username == null){
            username = intent.getStringExtra("username");
        }
        homeWelcomeTitle.setText("welcome, " + username);

        populateLearnRv();
        populateSoothingToolsRv();

        homeHelplineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HelplineActivity.class);
                startActivity(intent);
            }
        });

        homeCovidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CovidActivity.class);
                startActivity(intent);
            }
        });

        homeSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void populateLearnRv(){
        recyclerViewLearn = homeElement.findViewById(R.id.homeRvLearn);
        learnLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerViewLearn.setLayoutManager(learnLayoutManager);

        learnAdapter = new LearnAdapter();
        learnListSize = db.learnDao().getAll().size();
        learnElementArrayList = new ArrayList<String>();
        for(int i = 0; i < learnListSize; i++){
            learnElementArrayList.add(db.learnDao().getAll().get(i).getName());
        }
        learnAdapter.setData(learnElementArrayList);
        recyclerViewLearn.setAdapter(learnAdapter);
    }

    private void populateSoothingToolsRv(){
        recyclerViewSoothingTools = homeElement.findViewById(R.id.homeRvSoothingTools);
        soothingToolsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSoothingTools.setLayoutManager(soothingToolsLayoutManager);

        soothingToolsAdapter = new SoothingToolsAdapter();
        sTElementArrayList = new ArrayList<String>();
        sTElementArrayList.add("EXERCISES");
        sTElementArrayList.add("MOOD TRACKER");
        sTElementArrayList.add("FORUM");
        sTElementArrayList.add("MEDITATE");
        soothingToolsAdapter.setData(sTElementArrayList);
        recyclerViewSoothingTools.setAdapter(soothingToolsAdapter);
    }

}
