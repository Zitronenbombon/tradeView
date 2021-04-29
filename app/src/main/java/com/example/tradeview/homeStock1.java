package com.example.tradeview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class homeStock1 extends Fragment {
    TextView homefragmenttextview;
    Button buttonKaufen;
    Button buttonVerkaufen;


  //?  FragmentTransaction mFragmenttransactionhome;

    public homeStock1() {
        //required empty public constructoe :D OKKK=!=!=!=!=?!?!?!?!?!!
    }


//__________________________________________________________________________________________________________________________________________
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater1, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {// Inflate the layout for this fragment
        View v = inflater1.inflate(R.layout.fragment_home_stock1, container, false);

        //homefragmenttextview = (TextView) v.findViewById(R.id.homefragmenttextviewid);



//go to buy fragment:
        buttonKaufen = (Button) v.findViewById(R.id.kaufenid2);
        buttonKaufen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmenttransactionBUY = getFragmentManager().beginTransaction();
                fragmenttransactionBUY.replace(R.id.unteresfragment_containerid, new buyStock1(), "HOMETOBUY").commit();
                fragmenttransactionBUY.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right); //vorher war alles in der klammer 2 mal, damit auch beim back button passiert ? oder so


                }
        });
//go to sell fragment:
        buttonVerkaufen = (Button) v.findViewById(R.id.verkaufenid2);
        buttonVerkaufen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmenttransactionSELL = getFragmentManager().beginTransaction();
                fragmenttransactionSELL.replace(R.id.unteresfragment_containerid, new sellStock1(), "HOMETOSELL").commit();
                fragmenttransactionSELL.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right); //vorher war alles in der klammer 2 mal, damit auch beim back button passiert ? oder so

            }
        });






        return v;
    }


}
