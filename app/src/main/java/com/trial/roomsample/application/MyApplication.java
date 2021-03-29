package com.trial.roomsample.application;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.room.Room;
import com.trial.roomsample.db.AppDatabase;
public class MyApplication extends Activity
{
    AppDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(db == null)
        {
            db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "database-name").build();
        }
    }
}
