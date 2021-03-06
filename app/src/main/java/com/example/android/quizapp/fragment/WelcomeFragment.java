package com.example.android.quizapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.quizapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    Context mContext;

    private EditText mNameEditText;
    private EditText mEmailEditText;
    private Button mSubmitButton;

    public WelcomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_welcome, container, false);

        mContext = getContext();

        mNameEditText = (EditText) v.findViewById(R.id.name_editText);
        mEmailEditText = (EditText) v.findViewById(R.id.email_editText);

        mSubmitButton = (Button) v.findViewById(R.id.start_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mNameEditText.getText().toString().isEmpty()) {
                    Toast.makeText(mContext, "You forgot to put your name", Toast.LENGTH_SHORT).show();
                } else if (mEmailEditText.getText().toString().isEmpty()) {
                    Toast.makeText(mContext, "You forgot to put your Email", Toast.LENGTH_SHORT).show();
                } else {
                    QuizFragment quizFragment = new QuizFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, quizFragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });
        return v;
    }


}
