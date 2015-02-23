package com.example.davis.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
    private AudioPlayer mPlayer = new AudioPlayer();

    private Button mPlayButton;
    private Button mStopButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setText("Play");

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(mPlayButton.getText().equals("Play")){
                    mPlayButton.setText("Pause");
                    mPlayer.play(getActivity());
                }

                else if(mPlayButton.getText().equals("Pause")){
                    mPlayButton.setText("Play");
                    mPlayer.pause();
                }
            }
        });

        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPlayer.stop();
                mPlayButton.setText("Play");
             }
        });

        mPlayButton.setText("Play");
        return v;
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        super.onDestroy();
    }
}