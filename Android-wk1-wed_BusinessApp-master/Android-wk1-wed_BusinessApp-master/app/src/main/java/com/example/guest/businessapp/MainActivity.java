package com.example.guest.businessapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.buttonGallery) Button mButtonGallery;
    @Bind(R.id.buttonRates) Button mButtonRates;
    @Bind(R.id.buttonInfo) Button mButtonInfo;
    @Bind(R.id.buttonSwag) Button mButtonSwag;
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.imageDocksideCharters) ImageView mImageDockside;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface lobster = Typeface.createFromAsset(getAssets(), "fonts/Lobster_1.3.otf");
        mTitleTextView.setTypeface(lobster);

        mButtonGallery.setOnClickListener(this);
        mButtonRates.setOnClickListener(this);
        mButtonInfo.setOnClickListener(this);
        mButtonSwag.setOnClickListener(this);

        //image saved in the res/drawable folder
        Picasso.with(this).load(R.drawable.mountain).fit().centerInside().into(mImageDockside);
    }


    @Override
    public void onClick(View v) {

        if(v == mButtonGallery){
            Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
            startActivity(intent);
        } else if(v == mButtonInfo){
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent);
        } else if(v == mButtonRates){
            Intent intent = new Intent(MainActivity.this, RatesActivity.class);
            startActivity(intent);
        } else if(v == mButtonSwag){
            Intent intent = new Intent(MainActivity.this, SwagActivity.class);
            startActivity(intent);
        }

    }
}
