package com.example.infs3605v1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HelplineDao {

    @Query("SELECT * FROM helpline")
    List<Helpline> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Helpline helpline);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Helpline> helplineList);

    @Query("DELETE FROM helpline")
    public void deleteAll();

    @Delete
    void delete(Helpline helpline);

}
