package com.example.android.musicalstructure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Java for Now Playing activity
 */

public class PlayingActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private double songLength;
    private double currentTime;
    private double timeRemaining;
    private int skipForward = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the correct xml layout file
        setContentView(R.layout.activity_playing);

        // Set IDs for each onClickListener //

        ImageView play = (ImageView) findViewById(R.id.play);
        ImageView pause = (ImageView) findViewById(R.id.pause);
        final ImageView skip = (ImageView) findViewById(R.id.forward);
        ImageView nowPlaying = (ImageView) findViewById(R.id.now_playing_icon);
        ImageView recentPlay = (ImageView) findViewById(R.id.recent_icon);
        ImageView library = (ImageView) findViewById(R.id.library_icon);
        ImageView store = (ImageView) findViewById(R.id.store_icon);

        // TODO: Create song list Array and make this work!
//        ArrayList<Integer> songList = new ArrayList<>();
//        songList.add(R.raw.imalive);
//        songList.add(R.raw.howdoesamomentlastforever);


        // Media Player controls
        mediaPlayer = MediaPlayer.create(this, R.raw.imalive);
        // Calculate song length
        songLength = mediaPlayer.getDuration();
        // Calculate current position of song
        currentTime = mediaPlayer.getCurrentPosition();
        // Calculate song time remaining
        timeRemaining = songLength - currentTime;
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               // check if there is enough time remaining to skip forward
               if ((currentTime + skipForward) <= songLength) {
                   currentTime = currentTime + skipForward;
                   mediaPlayer.seekTo((int) currentTime);
               } else
                   Toast.makeText(getApplicationContext(), "There isn't enough time left to skip!", Toast.LENGTH_SHORT).show();
           }
        });

        // Set click listeners for icon tray //
        nowPlaying.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(PlayingActivity.this, PlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        recentPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent recentPlayIntent = new Intent(PlayingActivity.this, RecentActivity.class);
                startActivity(recentPlayIntent);
            }
        });

        library.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(PlayingActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });

        store.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent storeIntent = new Intent(PlayingActivity.this, StoreActivity.class);
                startActivity(storeIntent);
            }
        });
    }
}