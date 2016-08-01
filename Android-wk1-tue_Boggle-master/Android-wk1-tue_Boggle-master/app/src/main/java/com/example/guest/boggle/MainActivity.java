package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private String[] letters = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.newBoggleButton) Button mNewBoggleButton;
    @Bind(R.id.submit) Button mSubmitButton;
    @Bind(R.id.boggleOutput) TextView mBoggleOutput;
    @Bind(R.id.input) EditText mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNewBoggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                String boggle = "";

                int sum=0;
                do {
                    //create array of 8 random letters
                    boggle = letters[r.nextInt(letters.length - 1)] + letters[r.nextInt(letters.length - 1)] + letters[r.nextInt(letters.length - 1)] + letters[r.nextInt(letters.length - 1)] + letters[r.nextInt(letters.length - 1)] + letters[r.nextInt(letters.length - 1)] + letters[r.nextInt(letters.length - 1)] + letters[r.nextInt(letters.length - 1)];

                    //make sure array has at least two vowels
                    for(int j=0; j<boggle.length(); j++) {
                        char letter = boggle.charAt(j);
                        if(letter=='a'|| letter=='e'|| letter=='i'|| letter=='o'|| letter=='u') {
                            sum++;
                        }
                    }
                } while (sum < 2);


                //print array to setText boggleOutput
                mBoggleOutput.setText(boggle);
            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String userGuess = mInput.getText().toString();
                String boggleTemp = mBoggleOutput.getText().toString();

                Log.d(TAG, "userGuess: " + userGuess + "\nboggleTemp: " + boggleTemp);
            }
        });
    }
}
