package com.trinideal.getmotivated;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String TAG = "MainActivityFragment";
    private RandomPlayer mPlayer = new RandomPlayer();
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


        mEasyButton = (Button) v.findViewById(R.id.easyButton);
        mEasyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playRandom("test");
            }
        });

        mMediumButton = (Button) v.findViewById(R.id.mediumButton);
        mMediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRandom("test");
            }
        });

        mHardButton = (Button) v.findViewById(R.id.hardButton);
        mHardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRandom("test");
            }
        });


        return v;

    }

    @Override
    public void onStop() {
        super.onStop();
        mPlayer.stop();
    }

    private void playRandom(String folder) {
        mPlayer.playRandomFromFolder(getActivity(),folder, getActivity().getAssets());
    }





}
