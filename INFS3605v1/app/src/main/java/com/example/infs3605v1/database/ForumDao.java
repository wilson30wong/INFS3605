package com.example.infs3605v1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ForumDao {

    @Query("SELECT * FROM forum")
    List<Forum> getAll();

    @Query("SELECT * FROM forum WHERE id = :id")
    Forum findForumById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Forum forum);

    @Delete
    void delete(Forum forum);

    @Query("DELETE FROM forum")
    public void deleteAll();

}