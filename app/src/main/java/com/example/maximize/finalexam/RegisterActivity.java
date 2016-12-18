package com.example.maximize.finalexam;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Utility.LoadDatabase;
import db.DatabaseHelper;

/**
 * Created by maximize on 12/18/2016 AD.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText edt_name, edt_username, edt_password;
    private Button btn_create;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_create = (Button) findViewById(R.id.btn_create_account);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strName = edt_name.getText().toString().trim();
                String strUsername = edt_username.getText().toString().trim();
                String strPassword = edt_password.getText().toString().trim();

//                new LoadDatabase(getApplicationContext(), DatabaseHelper.TABLE_NAME);

                if (LoadDatabase.memberList.contains(strUsername)){

                    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
                    dialog.setTitle("Registration failed!");
                    dialog.setMessage("Username already exists");
                    dialog.setCancelable(false);
                    dialog.show();

                }else if(!"".equals(strName) && !"".equals(strUsername) &&!"".equals(strPassword)) {
                    DatabaseHelper helper = new DatabaseHelper(RegisterActivity.this);
                    SQLiteDatabase db = helper.getWritableDatabase();

                    ContentValues cv = new ContentValues();
                    cv.put(DatabaseHelper.COL_NAME, strName);
                    cv.put(DatabaseHelper.COL_USERNAME, strUsername);
                    cv.put(DatabaseHelper.COL_PASSWORD, strPassword);

                    db.insert(DatabaseHelper.TABLE_NAME, null, cv);

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(getApplicationContext(),"please input an information to complete",Toast.LENGTH_LONG).show();
                }




            }
        });

    }
}
