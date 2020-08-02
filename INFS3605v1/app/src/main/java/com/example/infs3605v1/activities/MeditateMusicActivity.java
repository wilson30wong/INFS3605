package com.example.infs3605v1.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.infs3605v1.R;
import com.example.infs3605v1.api.YoutubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MeditateMusicActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    ConstraintLayout meditationMusic1;
    ConstraintLayout meditationMusic2;
    ConstraintLayout meditationMusic3;
    TextView meditationMusicTitle;

    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate_music);

        youTubePlayerView = findViewById(R.id.youtubePlayerView);

        meditationMusic1 = findViewById(R.id.meditationMusic1);
        meditationMusicTitle = meditationMusic1.findViewById(R.id.meditationMusicTitle);
        meditationMusicTitle.setText("Yellow Brick Cinema Livestream");
        meditationMusic2 = findViewById(R.id.meditationMusic2);
        meditationMusicTitle = meditationMusic2.findViewById(R.id.meditationMusicTitle);
        meditationMusicTitle.setText("Body Mind Zone Livestream");
        meditationMusic3 = findViewById(R.id.meditationMusic3);
        meditationMusicTitle = meditationMusic3.findViewById(R.id.meditationMusicTitle);
        meditationMusicTitle.setText("Chilled Cow Livestream");

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                meditationMusic1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        youTubePlayer.loadVideo("FHjeSu9dS9c");
                    }
                });
                meditationMusic2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        youTubePlayer.loadVideo("06lHV2Wnf7M");
                    }
                });
                meditationMusic3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        youTubePlayer.loadVideo("5qap5aO4i9A");
                    }
                });
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        youTubePlayerView.initialize(YoutubeConfig.getYoutubeAPI(), onInitializedListener);

    }

}

