package com.trial.roomsample.db.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.trial.roomsample.db.entity.User;
@Dao
public interface UserDao
{
    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE uid IN (:ids)")
    List<User>  loadAllByIds(int []ids);

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND last_name LIKE :lastName LIMIT 1")
    User findByName(String firstName , String lastName);

    @Insert
    void insert(User users);

   @Insert
    void delete(User user);


}
