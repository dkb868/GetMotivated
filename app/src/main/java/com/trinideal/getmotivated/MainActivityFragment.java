package com.trinideal.getmotivated;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Field;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private AudioPlayer mPlayer = new AudioPlayer();
    private Button mEasyButton;
    private Button mMediumButton;
    private Button mHardButton;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        final int[] arnie = {R.raw.one, R.raw.two, R.raw.three, R.raw.four,
            R.raw.five, R.raw.six, R.raw.seven, R.raw.eight, R.raw.nine, R.raw.ten};

        mEasyButton = (Button) v.findViewById(R.id.easyButton);
        mEasyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playRandom(arnie);

            }
        });

        mMediumButton = (Button) v.findViewById(R.id.mediumButton);
        mMediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRandom(arnie);
            }
        });

        mHardButton = (Button) v.findViewById(R.id.hardButton);
        mHardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRandom(arnie);
            }
        });



        return v;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }

    private void playRandom(int[] array) {
        mPlayer.play(getActivity(), array[(int) (Math.random() * array.length)]);
    }


}
