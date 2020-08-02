package com.example.infs3605v1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LearnDao {

    @Query("SELECT * FROM learn")
    List<Learn> getAll();

    @Query("SELECT * FROM learn WHERE name = :name")
    Learn findLearnByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Learn learn);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Learn> learnList);

    @Delete
    void delete(Learn learn);

    @Query("DELETE FROM learn")
    public void deleteAll();

}
