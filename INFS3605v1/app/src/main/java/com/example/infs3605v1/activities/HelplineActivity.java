package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.infs3605v1.R;
import com.example.infs3605v1.adapters.HelplineAdapter;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.Helpline;

import java.util.ArrayList;

public class HelplineActivity extends AppCompatActivity {

    RecyclerView recyclerViewHelpline;
    RecyclerView.LayoutManager helplineLayoutManager;

    AppDatabase db;
    ArrayList<Helpline> helplineArrayList;
    HelplineAdapter helplineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        db = AppDatabase.getInstance(getApplicationContext());
        populateHelplineRv();

    }

    private void populateHelplineRv(){
        recyclerViewHelpline = findViewById(R.id.helplineRv);
        helplineLayoutManager = new LinearLayoutManager(getApplicationContext().getApplicationContext());
        recyclerViewHelpline.setLayoutManager(helplineLayoutManager);

        helplineAdapter = new HelplineAdapter();
        helplineArrayList = new ArrayList(db.helplineDao().getAll());
        helplineAdapter.setData(helplineArrayList);
        recyclerViewHelpline.setAdapter(helplineAdapter);
    }

}
