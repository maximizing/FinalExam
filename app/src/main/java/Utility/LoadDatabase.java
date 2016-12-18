package Utility;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import db.DatabaseHelper;
import model.member;



/**
 * Created by maximize on 12/18/2016 AD.
 */

public class LoadDatabase {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private String DatabaseName;
    private Context mContext;
    public static ArrayList<member> memberList = new ArrayList<>();


    public LoadDatabase(Context context, String database_name) {
        this.DatabaseName = database_name;
        this.mContext = context;

        memberList.clear();

        mHelper = new DatabaseHelper(mContext);
        mDb = mHelper.getWritableDatabase();

        Cursor cursor = mDb.query(DatabaseName, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
                String strName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                String strUsername = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USERNAME));
                String strPassword = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));

                member member = new member();
                member.setNames(strName);
                member.setUsername(strUsername);
            member.setPassword(strPassword);
                memberList.add(member);



    }
        cursor.close();
        //mDb.close();
        //mHelper.close();
    }


}
