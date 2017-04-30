package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Java for Store activity
 */

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the correct xml layout file
        setContentView(R.layout.activity_store);

        // Set IDs for each onClickListener //

        ImageView nowPlaying = (ImageView) findViewById(R.id.now_playing_icon);
        ImageView recentPlay = (ImageView) findViewById(R.id.recent_icon);
        ImageView library = (ImageView) findViewById(R.id.library_icon);
        ImageView store = (ImageView) findViewById(R.id.store_icon);

        // Set click listeners for icon tray //
        nowPlaying.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(StoreActivity.this, PlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        recentPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent recentPlayIntent = new Intent(StoreActivity.this, RecentActivity.class);
                startActivity(recentPlayIntent);
            }
        });

        library.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(StoreActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });

        store.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent storeIntent = new Intent(StoreActivity.this, StoreActivity.class);
                startActivity(storeIntent);
            }
        });
    }

}
