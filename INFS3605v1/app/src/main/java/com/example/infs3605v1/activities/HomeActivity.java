package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.infs3605v1.R;
import com.example.infs3605v1.adapters.LearnAdapter;
import com.example.infs3605v1.adapters.SoothingToolsAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ConstraintLayout homeElement;
    RecyclerView.LayoutManager learnLayoutManager;
    RecyclerView recyclerViewLearn;
    RecyclerView.LayoutManager soothingToolsLayoutManager;
    RecyclerView recyclerViewSoothingTools;
    LinearLayout toolboxButtonLayer;
    Button helplineButton;
    Button covidButton;
    Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeElement = findViewById(R.id.homeElement);
        toolboxButtonLayer = homeElement.findViewById(R.id.toolboxButtonLayer);
        helplineButton = toolboxButtonLayer.findViewById(R.id.helplineButton);
        covidButton = toolboxButtonLayer.findViewById(R.id.covidButton);
        settingsButton = toolboxButtonLayer.findViewById(R.id.settingsButton);

        recyclerViewLearn = homeElement.findViewById(R.id.rv_learn);
        learnLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerViewLearn.setLayoutManager(learnLayoutManager);

        recyclerViewSoothingTools = homeElement.findViewById(R.id.rv_soothingTools);
        soothingToolsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSoothingTools.setLayoutManager(soothingToolsLayoutManager);

        LearnAdapter learnAdapter = new LearnAdapter();
        ArrayList<String> learnElementArrayList = new ArrayList<String>();
        learnElementArrayList.add("anger");
        learnElementArrayList.add("anxiety");
        learnElementArrayList.add("depression");
        learnElementArrayList.add("other");
        learnElementArrayList.add("other");
        learnAdapter.setData(learnElementArrayList);
        recyclerViewLearn.setAdapter(learnAdapter);

        SoothingToolsAdapter soothingToolsAdapter = new SoothingToolsAdapter();
        ArrayList<String> sTElementArrayList = new ArrayList<String>();
        sTElementArrayList.add("EXERCISES");
        sTElementArrayList.add("MOOD TRACKER");
        sTElementArrayList.add("OTHER");
        sTElementArrayList.add("OTHER");
        sTElementArrayList.add("OTHER");
        soothingToolsAdapter.setData(sTElementArrayList);
        recyclerViewSoothingTools.setAdapter(soothingToolsAdapter);

        helplineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HelplineActivity.class);
                startActivity(intent);
            }
        });

        covidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CovidActivity.class);
                startActivity(intent);
            }
        });

    }
}
