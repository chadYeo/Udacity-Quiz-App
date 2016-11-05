package com.example.android.quizapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.android.quizapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    EditText mQ1_A_editText;
    RadioGroup mQ2_radioGroup;

    CheckBox mQ3_Opt1_checkBox;
    CheckBox mQ3_Opt2_checkBox;
    CheckBox mQ3_Opt3_checkBox;

    EditText mQ4_A_editText;
    RadioGroup mQ5_radioGroup;

    CheckBox mQ6_Opt1_checkBox;
    CheckBox mQ6_Opt2_checkBox;
    CheckBox mQ6_Opt3_checkBox;

    Button submitButton;

    Context mContext;

    Integer score;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        initialView(view);
        
        return view;
    }

    public void initialView(View view) {
        score = 0;

        mContext = view.getContext();

        mQ1_A_editText = (EditText)view.findViewById(R.id.Q1_A_editText);
        mQ2_radioGroup = (RadioGroup)view.findViewById(R.id.Q2_radioGroup);

        mQ3_Opt1_checkBox = (CheckBox)view.findViewById(R.id.Q3_Opt1_checkBox);
        mQ3_Opt2_checkBox = (CheckBox)view.findViewById(R.id.Q3_Opt2_checkBox);
        mQ3_Opt3_checkBox = (CheckBox)view.findViewById(R.id.Q3_Opt3_checkBox);

        mQ4_A_editText = (EditText)view.findViewById(R.id.Q4_A_editText);
        mQ5_radioGroup = (RadioGroup)view.findViewById(R.id.Q5_radioGroup);

        mQ6_Opt1_checkBox = (CheckBox)view.findViewById(R.id.Q6_Opt1_checkBox);
        mQ6_Opt2_checkBox = (CheckBox)view.findViewById(R.id.Q6_Opt2_checkBox);
        mQ6_Opt3_checkBox = (CheckBox)view.findViewById(R.id.Q6_Opt3_checkBox);

        submitButton = (Button)view.findViewById(R.id.submit_button);
    }

}
