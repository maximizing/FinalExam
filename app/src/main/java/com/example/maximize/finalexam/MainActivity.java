package com.example.maximize.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by maximize on 12/18/2016 AD.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String strName = intent.getStringExtra("name").toString();

        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText(strName);

    }
}
