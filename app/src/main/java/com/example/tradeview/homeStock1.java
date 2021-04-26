package com.example.tradeview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class homeStock1 extends Fragment {
    TextView homefragmenttextview;
  //?  FragmentTransaction mFragmenttransactionhome;

    public homeStock1() {
        //required empty public constructoe :D OKKK=!=!=!=!=?!?!?!?!?!!
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater1, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater1.inflate(R.layout.fragment_home_stock1, container, false);


        //connect the visual components to my javacode
        homefragmenttextview = (TextView) v.findViewById(R.id.homefragmenttextviewid);

        return v;

    }
}
