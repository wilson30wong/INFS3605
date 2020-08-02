package com.example.infs3605v1.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "username",
        childColumns = "username",
        onDelete = ForeignKey.CASCADE))
public class MoodTracker {

    @PrimaryKey
    @NonNull
    String moodEntry;
    String username;
    String date;
    int mood;

    public MoodTracker(){

    }

    public MoodTracker(String moodEntry, String username, String date, int mood){
        this.moodEntry = moodEntry;
        this.username = username;
        this.date = date;
        this.mood = mood;
    }

    public String getMoodEntry() {
        return moodEntry;
    }

    public void setMoodEntry(String moodEntry) {
        this.moodEntry = moodEntry;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }
}
