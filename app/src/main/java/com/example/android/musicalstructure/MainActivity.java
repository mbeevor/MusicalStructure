package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        // Find the View that shows Now Playing
        LinearLayout nowPlaying = (LinearLayout) findViewById(R.id.now_playing);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });


        // Find the View that shows Recently Played
        LinearLayout recentPlay = (LinearLayout) findViewById(R.id.recently_played);

        // Set a click listener on that View
        recentPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent recentPlayIntent = new Intent(MainActivity.this, RecentActivity.class);
                startActivity(recentPlayIntent);
            }
        });

        // Find the View that shows the Library
        LinearLayout library = (LinearLayout) findViewById(R.id.library);

        // Set a click listener on that View
        library.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });

        // Find the View that shows the Store
        LinearLayout store = (LinearLayout) findViewById(R.id.store);

        // Set a click listener on that View
        store.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent storeIntent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(storeIntent);
            }
        });
    }
}
