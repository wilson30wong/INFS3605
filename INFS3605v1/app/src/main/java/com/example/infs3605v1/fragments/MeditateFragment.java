package com.example.infs3605v1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.infs3605v1.R;
import com.example.infs3605v1.activities.MeditateMusicActivity;
import com.example.infs3605v1.methods.Methods;

public class MeditateFragment extends Fragment {

    LinearLayout meditateFragmentButtonLayer;
    Button medidateFragmentMusic;
    Button medidateFragmentTutorials;
    FrameLayout frameLayout;
    Toast toast;

    Intent intent;
    Methods methods;

    public MeditateFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_meditate, container, false);

        meditateFragmentButtonLayer = frameLayout.findViewById(R.id.meditateFragmentButtonLayer);
        medidateFragmentMusic = meditateFragmentButtonLayer.findViewById(R.id.medidateFragmentMusic);
        medidateFragmentTutorials = meditateFragmentButtonLayer.findViewById(R.id.medidateFragmentTutorials);

        methods = new Methods(getActivity().getApplicationContext());

        medidateFragmentMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity().getApplicationContext(), MeditateMusicActivity.class);
                startActivity(intent);
            }
        });
        medidateFragmentTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(getActivity().getApplicationContext(), "Coming Soon!", Toast.LENGTH_LONG);
                methods.toastConfiguration(toast);
                toast.show();

//                intent = new Intent(getActivity().getApplicationContext(), MeditateTutorialsActivity.class);
//                startActivity(intent);
            }
        });

        return frameLayout;
    }

}
