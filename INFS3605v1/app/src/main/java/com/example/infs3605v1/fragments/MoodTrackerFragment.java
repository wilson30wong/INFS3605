package com.example.infs3605v1.fragments;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.infs3605v1.R;

public class MoodTrackerFragment extends Fragment {

    ConstraintLayout moodTrackerFragmentElement;
    HorizontalScrollView sv_moodTrackerToday;
    ConstraintLayout moodHappy;
    ConstraintLayout moodSad;
    ConstraintLayout moodAngry;
    ConstraintLayout moodLoved;
    ConstraintLayout moodOther;
    TextView moodTitle;


    public MoodTrackerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_mood_tracker, container, false);

        moodTrackerFragmentElement = frameLayout.findViewById(R.id.moodTrackerFragmentElement);
        sv_moodTrackerToday = moodTrackerFragmentElement.findViewById(R.id.sv_moodTrackerToday);

        moodHappy = sv_moodTrackerToday.findViewById(R.id.moodHappy);
        moodSad = sv_moodTrackerToday.findViewById(R.id.moodSad);
        moodAngry = sv_moodTrackerToday.findViewById(R.id.moodAngry);
        moodLoved = sv_moodTrackerToday.findViewById(R.id.moodLoved);
        moodOther = sv_moodTrackerToday.findViewById(R.id.moodOther);
        moodTitle = moodHappy.findViewById(R.id.moodTitle);
        moodTitle.setText("happy");
        moodTitle = moodSad.findViewById(R.id.moodTitle);
        moodTitle.setText("sad");
        moodTitle = moodAngry.findViewById(R.id.moodTitle);
        moodTitle.setText("angry");
        moodTitle = moodLoved.findViewById(R.id.moodTitle);
        moodTitle.setText("loved");
        moodTitle = moodOther.findViewById(R.id.moodTitle);
        moodTitle.setText("other");





        return frameLayout;
    }

}
