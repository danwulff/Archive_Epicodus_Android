package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MadLibStory extends AppCompatActivity {
    private TextView mName1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_lib_story);
        mName1 = (TextView) findViewById(R.id.name1);
        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name1");
        mName1.setText("First Name: " + name1);
    }


}
