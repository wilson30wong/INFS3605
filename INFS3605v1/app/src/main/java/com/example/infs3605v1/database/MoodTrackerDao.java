package com.example.infs3605v1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MoodTrackerDao {

    @Query("SELECT * FROM moodtracker")
    List<MoodTracker> getAll();

    @Query("SELECT * FROM moodtracker WHERE moodEntry = :moodEntry")
    MoodTracker findMoodTrackerByMoodEntry(String moodEntry);

    @Query("UPDATE moodtracker SET mood =:mood WHERE moodEntry = :moodEntry")
    void updateMoodTracker(int mood, String moodEntry);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MoodTracker moodTracker);

    @Delete
    void delete(MoodTracker moodTracker);

    @Query("DELETE FROM user")
    public void deleteAll();

}
