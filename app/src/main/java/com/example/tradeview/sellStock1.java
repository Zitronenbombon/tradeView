package com.example.tradeview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class sellStock1 extends Fragment {
    OnFragmentInteractionListener3 mListener3;


    TextView textsellfragment;
    Button sellbutton;
    Button buttonfragmentsellzurueck;



    public sellStock1() {
    //required empty public constructoe :D OKKK=!=!=!=!=?!?!?!?!?!!
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vvvvvvvvvvvvvv = inflater.inflate(R.layout.fragment_sell_stock1, container, false);
        //connect the visual components to my javacode
        textsellfragment = (TextView) vvvvvvvvvvvvvv.findViewById(R.id.textsellfragmentid);
        sellbutton = (Button) vvvvvvvvvvvvvv.findViewById(R.id.sellbuttonid);
        sellbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOpenhomefragment();
            }
        });

        buttonfragmentsellzurueck = vvvvvvvvvvvvvv.findViewById(R.id.zurueckbuttonsellfragmentid);
        buttonfragmentsellzurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmenttransactionBACKTOHOME = getParentFragmentManager().beginTransaction();
                fragmenttransactionBACKTOHOME.replace(R.id.unteresfragment_containerid, new homeStock1(), "BACKTOHOMEFROMSELL").commit();
            }
        });

        return vvvvvvvvvvvvvv;
    }



    //7 button für weiterleiten des eingebenen AMOUNTS (die folgenden kommen von codinginflow (mglw. outdated code ... bei mir kamen diese dummy variables nicht)
    // TODO: Rename method, update argument and hook method into UI event
    public void mOpenhomefragment() {
        if (mListener3 != null) { mListener3.onFragmentInteraction3(); }
    }
    //onAttach and onDetach sind für das Weiterleiten des Textes irgendwie zuständig...
/*    @Override
    public void onAttach3(Context contexttt3) {
        super.onAttach3(contexttt3);
        if (contexttt3 instanceof buyStock1.OnFragmentInteractionListener) {
            mListener3 = (buyStock1.OnFragmentInteractionListener) contexttt3;
        } else {
            throw new RuntimeException(contexttt3.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach3() {
        super.onDetach3();
        mListener3 = null;
    }*/

    public interface OnFragmentInteractionListener3 {
        void onFragmentInteraction3();
    }
//______________________________________________________________________________________END




}
