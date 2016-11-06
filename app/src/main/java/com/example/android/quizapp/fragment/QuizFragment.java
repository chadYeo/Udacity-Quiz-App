package com.example.android.quizapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.quizapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    EditText mQ1_A_editText;
    RadioGroup mQ2_radioGroup;
    CheckBox mQ3_Opt1_checkBox, mQ3_Opt2_checkBox, mQ3_Opt3_checkBox;
    EditText mQ4_A_editText;
    RadioGroup mQ5_radioGroup;
    CheckBox mQ6_Opt1_checkBox, mQ6_Opt2_checkBox, mQ6_Opt3_checkBox;

    Boolean isQ1Scored;
    Boolean isQ2Scored;
    Boolean isQ3Scored;
    Boolean isQ4Scored;
    Boolean isQ5Scored;
    Boolean isQ6Scored;

    Button submitButton;

    Context mContext;

    Integer score;

    private static final String LOG_TAG = QuizFragment.class.getSimpleName();

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        initialView(view);
        radioGroupListener();

        onSubmitButtonClicked();

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

        isQ1Scored = false;
        isQ2Scored = false;
        isQ3Scored = false;
        isQ4Scored = false;
        isQ5Scored = false;
        isQ6Scored = false;
    }

    public void editTextViewListener() {
        String enteredEditTextQ1 = mQ1_A_editText.getText().toString().toLowerCase();
        String enteredEditTextQ4 = mQ4_A_editText.getText().toString().toLowerCase();

        String answerToQ1 = getResources().getString(R.string.Q1_A).toLowerCase();
        String answerToQ4 = getResources().getString(R.string.Q4_A).toLowerCase();

        if (enteredEditTextQ1.equals(answerToQ1) && !isQ1Scored) {
            score++;
            isQ1Scored = true;
        }

        if (enteredEditTextQ4.equals(answerToQ4) && !isQ4Scored) {
            score++;
            isQ4Scored = true;
        }
    }

    public void radioGroupListener() {
        mQ2_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Q2_Opt1_radioButton:
                        break;
                    case R.id.Q2_Opt2_radioButton:
                        if (!isQ2Scored) {
                            score++;
                            isQ2Scored = true;
                        }
                        break;
                    case R.id.Q2_Opt3_radioButton:
                        break;
                }
            }
        });

        mQ5_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Q5_Opt1_radioButton:
                        break;
                    case R.id.Q5_Opt2_radioButton:
                        if (!isQ5Scored) {
                            score++;
                            isQ5Scored = true;
                        }
                        break;
                    case R.id.Q5_Opt3_radioButton:
                        break;
                }
            }
        });
    }

    // This one is for Question 3
    public void checkBoxListenerForQ3() {
        if (mQ3_Opt1_checkBox.isChecked() &&
                !mQ3_Opt2_checkBox.isChecked() &&
                mQ3_Opt3_checkBox.isChecked() &&
                !isQ3Scored) {
            score++;
            isQ3Scored = true;
        }
    }

    // This one is for Question 6
    public void checkBoxListenerForQ6() {
        if (!mQ6_Opt1_checkBox.isChecked() &&
                mQ6_Opt2_checkBox.isChecked() &&
                mQ6_Opt3_checkBox.isChecked() &&
                !isQ6Scored) {
            score++;
            isQ6Scored = true;
        }
    }

    public void onSubmitButtonClicked() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextViewListener();
                checkBoxListenerForQ3();
                checkBoxListenerForQ6();
                Toast.makeText(mContext, "Score " + score, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
