package com.trial.roomsample.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.trial.roomsample.db.dao.UserDao;
import com.trial.roomsample.db.entity.User;
@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract UserDao userDao();
}
