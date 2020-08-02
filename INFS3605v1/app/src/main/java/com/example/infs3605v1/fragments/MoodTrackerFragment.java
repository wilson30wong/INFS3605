package com.example.infs3605v1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.infs3605v1.R;
import com.example.infs3605v1.activities.HomeActivity;
import com.example.infs3605v1.database.AppDatabase;
import com.example.infs3605v1.database.MoodTracker;
import com.example.infs3605v1.methods.Methods;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MoodTrackerFragment extends Fragment {

    ConstraintLayout moodTrackerFragmentElement;
    HorizontalScrollView moodTrackerTodaySv;
    ConstraintLayout mood1;
    ConstraintLayout mood2;
    ConstraintLayout mood3;
    ConstraintLayout mood4;
    ConstraintLayout mood5;
    TextView moodTitle;
    ConstraintLayout moodButton;
    ImageView moodImage;
    ConstraintLayout moodTrackerTodayElement;
    ImageView moodTrackerTodayImage;
    ConstraintLayout moodTrackerWeekElement;
    ImageView moodTrackerWeekImage;
    ConstraintLayout moodTrackerMonthElement;
    ImageView moodTrackerMonthImage;
    Toast toast;
    FrameLayout frameLayout;

    AppDatabase db;
    Methods methods;
    MoodTracker moodTracker;
    String moodEntry;
    Date dateRaw;
    String dateInput;
    SimpleDateFormat dateFormat;
    Calendar newCalender;
    ArrayList<Integer> moodArrayList;
    int totalMood;
    int aveageMood;


    public MoodTrackerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_mood_tracker, container, false);

        moodTrackerFragmentElement = frameLayout.findViewById(R.id.moodTrackerFragmentElement);
        moodTrackerTodaySv = moodTrackerFragmentElement.findViewById(R.id.moodTrackerTodaySv);
        moodTrackerTodayElement = frameLayout.findViewById(R.id.moodTrackerTodayElement);
        moodTrackerTodayImage = moodTrackerTodayElement.findViewById(R.id.moodTrackerTodayImage);
        moodTrackerWeekElement = frameLayout.findViewById(R.id.moodTrackerWeekElement);
        moodTrackerWeekImage = moodTrackerWeekElement.findViewById(R.id.moodTrackerWeekImage);
        moodTrackerMonthElement = frameLayout.findViewById(R.id.moodTrackerMonthElement);
        moodTrackerMonthImage = moodTrackerMonthElement.findViewById(R.id.moodTrackerMonthImage);

        mood1 = moodTrackerTodaySv.findViewById(R.id.mood1);
        mood2 = moodTrackerTodaySv.findViewById(R.id.mood2);
        mood3 = moodTrackerTodaySv.findViewById(R.id.mood3);
        mood4 = moodTrackerTodaySv.findViewById(R.id.mood4);
        mood5 = moodTrackerTodaySv.findViewById(R.id.mood5);

        db = AppDatabase.getInstance(getActivity().getApplicationContext());
        methods = new Methods(getActivity().getApplicationContext());

        populateMoodTracker();

        populateMoodTrackerToday(mood1, "ecstatic", 5);
        populateMoodTrackerToday(mood2, "happy", 4);
        populateMoodTrackerToday(mood3, "neutral", 3);
        populateMoodTrackerToday(mood4, "sad", 2);
        populateMoodTrackerToday(mood5, "angry", 1);

        moodButton = mood1.findViewById(R.id.moodButton);
        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMoodTrackerEntry(5);
            }
        });
        moodButton = mood2.findViewById(R.id.moodButton);
        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMoodTrackerEntry(4);
            }
        });
        moodButton = mood3.findViewById(R.id.moodButton);
        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMoodTrackerEntry(3);
            }
        });
        moodButton = mood4.findViewById(R.id.moodButton);
        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMoodTrackerEntry(2);
            }
        });
        moodButton = mood5.findViewById(R.id.moodButton);
        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMoodTrackerEntry(1);
            }
        });

        return frameLayout;
    }

    private void handleMoodTrackerEntry(int mood){
        moodEntry = HomeActivity.username + "-" + methods.getCurrentDate();
        moodTracker = new MoodTracker( moodEntry, HomeActivity.username, methods.getCurrentDate(), mood);
        if(db.moodTrackerDao().findMoodTrackerByMoodEntry(moodEntry) != null){
            db.moodTrackerDao().updateMoodTracker(mood, moodTracker.getMoodEntry());
        } else {
            db.moodTrackerDao().insert(moodTracker);
        }
        setMoodImage(moodTrackerTodayImage, mood);
    }

    private void populateMoodTrackerToday(ConstraintLayout moodTile, String title, int mood){
        moodTitle = moodTile.findViewById(R.id.moodTitle);
        moodTitle.setText(title);
        moodImage = moodTile.findViewById(R.id.moodImage);
        setMoodImage(moodImage, mood);
    }

    private void setMoodImage(ImageView imageView, int mood){
        switch(mood){
            case 1:{
                imageView.setImageResource(R.drawable.moodtracker_angry);
            } break;
            case 2: {
                imageView.setImageResource(R.drawable.moodtracker_sad);
            } break;
            case 3:{
                imageView.setImageResource(R.drawable.moodtracker_neutral);
            } break;
            case 4:{
                imageView.setImageResource(R.drawable.moodtracker_happy);
            } break;
            case 5:{
                imageView.setImageResource(R.drawable.moodtracker_ecstatic);
            } break;
        }
    }

    private void populateMoodTracker(){
        try{
            moodEntry = HomeActivity.username + "-" + methods.getCurrentDate();
            setMoodImage(moodTrackerTodayImage, db.moodTrackerDao().findMoodTrackerByMoodEntry(moodEntry).getMood());
        } catch(Exception e){
            toast = Toast.makeText(getActivity().getApplicationContext(), "Enter your mood for today", Toast.LENGTH_LONG);
            methods.toastConfiguration(toast);
            toast.show();
        }
        setMoodImage(moodTrackerWeekImage, calculateAverageMood(7));
        setMoodImage(moodTrackerMonthImage, calculateAverageMood(30));
    }

    private int calculateAverageMood(int timePeriod){
        moodArrayList = new ArrayList<Integer>();
        for(int i = 0; i < timePeriod; i++){
            newCalender = Calendar.getInstance();
            newCalender.add(Calendar.DATE, (i - (timePeriod - 1)));
            dateRaw = newCalender.getTime();
            dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
            dateInput  = dateFormat.format(dateRaw);
            moodEntry = HomeActivity.username + "-" + dateInput;
            if(db.moodTrackerDao().findMoodTrackerByMoodEntry(moodEntry) == null){
                continue;
            } else{
                moodArrayList.add(db.moodTrackerDao().findMoodTrackerByMoodEntry(moodEntry).getMood());
            }
        }
        if(moodArrayList.size() == 0){
            return 0;
        }
        totalMood = 0;
        for(int i = 0; i < moodArrayList.size(); i++){
            totalMood += moodArrayList.get(i);
        }
        aveageMood = totalMood / moodArrayList.size();
        return aveageMood;
    }

}
