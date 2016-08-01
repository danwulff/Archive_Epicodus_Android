package com.example.guest.businessapp;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Guest on 6/29/16.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTitleTextViewContent() {
        TextView titleTextView = (TextView) activity.findViewById(R.id.titleTextView);
        assertTrue("Dockside Charters".equals(titleTextView.getText().toString()));
    }

    @Test
    public void GalleryActivityStarted() {
        activity.findViewById(R.id.buttonGallery).performClick();
        Intent expectedIntent = new Intent(activity, GalleryActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @Test
    public void InfoActivityStarted() {
        activity.findViewById(R.id.buttonInfo).performClick();
        Intent expectedIntent = new Intent(activity, InfoActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @Test
    public void RatesActivityStarted() {
        activity.findViewById(R.id.buttonRates).performClick();
        Intent expectedIntent = new Intent(activity, RatesActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @Test
    public void SwagActivityStarted() {
        activity.findViewById(R.id.buttonSwag).performClick();
        Intent expectedIntent = new Intent(activity, SwagActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }



}