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
public class FragmentTestSecond extends Fragment{
    int a;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("SequenceSecond", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = 1;
        Log.d("SequenceSecond", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        Button btn = (Button)rootView.findViewById(R.id.secondBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.replace(R.id.container, new FragmentTest());
                fragmentTransaction.replace(R.id.container, new FragmentTestThird());
                fragmentTransaction.commit();
            }
        });
        Log.d("SequenceSecond", "onCreateView");
        Log.d("SequenceSecond",String.valueOf(++a));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("SequenceSecond", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("SequenceSecond", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("SequenceSecond", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("SequenceSecond", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("SequenceSecond", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("SequenceSecond", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SequenceSecond", "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("SequenceSecond", "onSaveInstanceState");
    }
}
