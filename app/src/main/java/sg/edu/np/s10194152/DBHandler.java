package sg.edu.np.s10194152;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context)
    {
        super(context, "T02DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create database table
        db.execSQL("CREATE TABLE USERS (name TEXT, description TEXT, id INTEGER, followed INTEGER)");

        //to generate and insert 20 users into table
        for(int i=0; i<20; i++)
        {
            ContentValues c = new ContentValues();
            c.put("name", "Name" + new Random().nextInt());
            c.put("description","Description " + new Random().nextInt());
            c.put("followed", new Random().nextInt()%2 == 0);
            db.insert("USERS", null, c);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS"); //by right, check for old version, patch up schema
        onCreate(db);
    }

    public ArrayList<User> getUser()
    {
        ArrayList<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM USERS", null);

        if(cursor.moveToNext())
        {
            User u = new User();
            u.setName(cursor.getString(0));
            u.setDescription(cursor.getString(1));
            u.setId(cursor.getInt(2));
            u.setFollowed(cursor.getInt(3)==0?false:true);

            userList.add(u);
        }
        cursor.close();
        db.close();
        return userList;
    }

    public void updateUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("followed", u.isFollowed());

        db.update("USERS", values, "id = ?", new String[]{ "" + u.getId()} );
        db.close();
    }
}
