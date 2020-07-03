package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.infs3605v1.R;
import com.example.infs3605v1.adapters.HelplineAdapter;
import com.example.infs3605v1.model.Helpline;

import java.util.ArrayList;

public class HelplineActivity extends AppCompatActivity {

    RecyclerView recyclerViewHelpline;
    RecyclerView.LayoutManager helplineLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        recyclerViewHelpline = findViewById(R.id.rv_helpline);
        helplineLayoutManager = new LinearLayoutManager(getApplicationContext().getApplicationContext());
        recyclerViewHelpline.setLayoutManager(helplineLayoutManager);

        HelplineAdapter helplineAdapter = new HelplineAdapter();
        ArrayList<Helpline> helplineArrayList = new ArrayList<Helpline>();
        helplineArrayList.add(new Helpline("www.beyondblue.org.au", "1300 22 4636","beyondblue is a national organisation that has a range of information and resources associated with depression and anxiety. "));
        helplineArrayList.add(new Helpline("www.lifeline.org.au", "13 11 14","Lifeline Australia provides a free, confidential, anonymous, 24hr telephone counselling service for adults needing emotional support."));
        helplineArrayList.add(new Helpline("other", "other", "other"));
        helplineArrayList.add(new Helpline("other", "other", "other"));
        helplineArrayList.add(new Helpline("other", "other", "other"));
        helplineArrayList.add(new Helpline("other", "other", "other"));
        helplineArrayList.add(new Helpline("other", "other", "other"));
        helplineAdapter.setData(helplineArrayList);
        recyclerViewHelpline.setAdapter(helplineAdapter);


    }
}
