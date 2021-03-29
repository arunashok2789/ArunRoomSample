package com.trial.roomsample;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.room.Room;
import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.OnClick;
import com.trial.roomsample.application.MyApplication;
import com.trial.roomsample.db.AppDatabase;
import com.trial.roomsample.db.dao.UserDao;
import com.trial.roomsample.db.entity.User;

public class MainActivity extends AppCompatActivity
{
    @Bind(R.id.firstName)
    EditText firstName;
    @Bind(R.id.lastName)
    EditText lastName;
    @Bind(R.id.submit)
    Button submit;
    AppDatabase db;
    String firstName1 ,lastName1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);

        if(db == null)
        {
            db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        }
    }

    @OnClick(R.id.submit)
    public void submit()
    {
        String submit = firstName.getText().toString() + lastName.getText().toString();
        User user = new User();
        List<User> users = new ArrayList<User>();
        user.setFirstName(firstName.getText().toString());
        user.setLastName(lastName.getText().toString());

        /*UserDao dao = db.userDao();

       dao.insertAll(users);
        Toast.makeText(getApplicationContext(),"Users are ..."+ dao.getAllUsers().get(0).getFirstName(),Toast.LENGTH_LONG).show();
        Log.e("firstName","...."+dao.getAllUsers().get(0).getFirstName());
        Log.e("lastName","...."+dao.getAllUsers().get(0).getLastName());*/

        new Test().execute(null,null,null);
        Log.e("firstname","..."+firstName1);
        Log.e("lasttname","..."+lastName1);

    }

    class Test extends AsyncTask<String, Integer, String>
    {

        @Override
        protected String doInBackground(String... strings)
        {
            User user = new User();
          /*  List<User> users = new ArrayList<User>();
            user.setFirstName(firstName.getText().toString());
            user.setLastName(lastName.getText().toString());

            UserDao dao = db.userDao();

            dao.insert(user);*/

            return null;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            new Test2().execute(null,null,null);

        }
    }

    class Test2 extends AsyncTask<String, String,String>
    {
        @Override
        protected String doInBackground(String... strings)
        {
            UserDao dao = db.userDao();
            List<User> user =  dao.getAllUsers();
            Log.e("size ", String.valueOf(user.size()));
            firstName1 = user.get(0).firstName;
            lastName1 = user.get(0).lastName;
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
        }
    }
}