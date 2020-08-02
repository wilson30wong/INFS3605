package com.example.infs3605v1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    List<Exercise> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Exercise exercise);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Exercise> exerciseList);

    @Query("DELETE FROM exercise")
    public void deleteAll();

    @Delete
    void delete(Exercise exercise);

}


