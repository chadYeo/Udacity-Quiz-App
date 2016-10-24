package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void selectFrag(View view) {

        QuizFragment qf = new QuizFragment();

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, qf);
        ft.addToBackStack(null);
        ft.commit();
    }
}
