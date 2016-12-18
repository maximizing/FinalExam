package com.example.maximize.finalexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import Utility.LoadDatabase;
import adapter.MemberListAdapter;

/**
 * Created by maximize on 12/18/2016 AD.
 */

public class UserListActivity extends AppCompatActivity {
    MemberListAdapter memberListAdapter;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        listView = (ListView) findViewById(R.id.listview);

        memberListAdapter = new MemberListAdapter(this, R.layout.view_item, LoadDatabase.memberList);
        listView.setAdapter(memberListAdapter);
    }
}
