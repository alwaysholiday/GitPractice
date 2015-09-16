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
public class FragmentTestThird extends Fragment{
    int a;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("SequenceThird", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = 20;
        Log.d("SequenceThird", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        Button btn = (Button)rootView.findViewById(R.id.thirdBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.container, new FragmentTest());
                fragmentTransaction.commit();
            }
        });

        Button loadBtn = (Button)rootView.findViewById(R.id.loadFirstBtn);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.popBackStack("First", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new FragmentTest());
                fragmentTransaction.commit();
            }
        });
        Log.d("SequenceThird", "onCreateView");
        Log.d("SequenceThird",String.valueOf(++a));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("SequenceThird", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("SequenceThird", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("SequenceThird", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("SequenceThird", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("SequenceThird", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("SequenceThird", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SequenceThird", "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("SequenceThird", "onSaveInstanceState");
    }
}
