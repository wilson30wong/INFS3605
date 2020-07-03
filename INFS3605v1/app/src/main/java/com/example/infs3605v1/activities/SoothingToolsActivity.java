package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.infs3605v1.R;
import com.example.infs3605v1.fragments.ExercisesFragment;
import com.example.infs3605v1.fragments.MoodTrackerFragment;

public class SoothingToolsActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Intent intent;
    String soothingToolsElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soothing_tools);

        intent = getIntent();
        soothingToolsElement = intent.getStringExtra("soothingToolsElement");
        System.out.println(soothingToolsElement);

        fragmentManager = getSupportFragmentManager();

        if(soothingToolsElement.equals("EXERCISES")){
            fragmentManager.beginTransaction().replace(R.id.fragmentSoothingTools, new ExercisesFragment()).commit();
        } else if (soothingToolsElement.equals("MOOD TRACKER")){
            fragmentManager.beginTransaction().replace(R.id.fragmentSoothingTools, new MoodTrackerFragment()).commit();

        }


    }
}
