package com.example.maximize.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Utility.LoadDatabase;
import db.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_username, edt_password;
    private Button btn_login,btn_create_account;
    Boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_create_account = (Button) findViewById(R.id.btn_reg);

        new DatabaseHelper(this);

        new LoadDatabase(this, DatabaseHelper.TABLE_NAME);


        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(k);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUsername = edt_username.getText().toString().trim();
                String strPassword = edt_password.getText().toString().trim();

                for (int i = 0; i < LoadDatabase.memberList.size(); i++) {
                    if (LoadDatabase.memberList.get(i).getUsername().toString().equals(strUsername) &&
                            LoadDatabase.memberList.get(i).getPassword().toString().equals(strPassword)) {

                        status = true;

                        Intent j = new Intent(LoginActivity.this, MainActivity.class);
                        j.putExtra("name", LoadDatabase.memberList.get(i).getNames().toString());
                        startActivity(j);
                        break;

                    }
                }

                if(!status){
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_show_list) {
            Intent intent = new Intent(this, UserListActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
