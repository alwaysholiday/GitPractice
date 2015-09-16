package com.example.estsoft.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by estsoft on 2015-06-01.
 */
public class FragmentTest extends Fragment{
    int a;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = 10;
        Log.d("Sequence","onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button btn = (Button)rootView.findViewById(R.id.firstBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack("First");
                fragmentTransaction.replace(R.id.container, new FragmentTestSecond());
                fragmentTransaction.commit();
            }
        });

        Button loadBtn = (Button)rootView.findViewById(R.id.loadThirdBtn);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack("Third", 0);
            }
        });
        Log.d("Sequence", "onCreateView");
        Log.d("Sequence",String.valueOf(++a));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Sequence", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Sequence", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Sequence", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Sequence", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Sequence", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Sequence", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Sequence", "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Sequence", "onSaveInstanceState");
    }
}
