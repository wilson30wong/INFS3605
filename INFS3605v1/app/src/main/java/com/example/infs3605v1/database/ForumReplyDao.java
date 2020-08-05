package com.example.infs3605v1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ForumReplyDao {

    @Query("SELECT * FROM forumreply")
    List<ForumReply> getAll();

    @Query("SELECT * FROM forumreply WHERE id = :id")
    ForumReply findForumReplyById(int id);

    @Query("SELECT * FROM forumreply WHERE forumId = :forumId")
    List<ForumReply> findForumReplyByForumId(int forumId);

    @Query("SELECT * FROM forumreply WHERE forumId = :forumId ORDER BY id DESC LIMIT 1")
    ForumReply findMostRecentForumReplyByForum(int forumId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ForumReply forumReply);

    @Delete
    void delete(ForumReply forumReply);

    @Query("DELETE FROM forumreply")
    public void deleteAll();

}