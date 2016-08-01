package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mSubmitStoryButton;
    private EditText mName1EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName1EditText = (EditText) findViewById(R.id.name1);
        mSubmitStoryButton = (Button) findViewById(R.id.submitStoryButton);

        mSubmitStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = mName1EditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MadLibStory.class);
                intent.putExtra("name1", name1);
                startActivity(intent);
            }
        });
    }
}
