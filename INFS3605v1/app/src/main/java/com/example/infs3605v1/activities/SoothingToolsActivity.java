package com.example.infs3605v1.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.infs3605v1.R;
import com.example.infs3605v1.fragments.ExercisesFragment;
import com.example.infs3605v1.fragments.ForumFragment;
import com.example.infs3605v1.fragments.MeditateFragment;
import com.example.infs3605v1.fragments.MoodTrackerFragment;

public class SoothingToolsActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Intent intent;
    String soothingToolsElement;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soothing_tools);

        intent = getIntent();
        soothingToolsElement = intent.getStringExtra("soothingToolsElement");
        fragmentManager = getSupportFragmentManager();

        if(soothingToolsElement.equals("EXERCISES")){
            fragmentManager.beginTransaction().replace(R.id.fragmentSoothingTools, new ExercisesFragment()).commit();
        } else if (soothingToolsElement.equals("MOOD TRACKER")){
            fragmentManager.beginTransaction().replace(R.id.fragmentSoothingTools, new MoodTrackerFragment()).commit();
        } else if (soothingToolsElement.equals("FORUM")) {
            fragmentManager.beginTransaction().replace(R.id.fragmentSoothingTools, new ForumFragment()).commit();
        } else if (soothingToolsElement.equals("MEDITATE")) {
            fragmentManager.beginTransaction().replace(R.id.fragmentSoothingTools, new MeditateFragment()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else if(count % 2 == 0){
            intent = new Intent(getApplicationContext(), HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

}
