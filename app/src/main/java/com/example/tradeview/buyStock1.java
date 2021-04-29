package com.example.tradeview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/*
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link buyStock1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class buyStock1 extends Fragment {

     Button buybutton;
     Button buttonfragmentbuyzurueck;
     EditText aktienanzahl;
     int aktienpreis;
     int verfuegbarerbestand;
     TextView aktienkaufpreis; //muss geändert werden im Fall der Fälle
     TextView verfuegbarerbestandanzeige;


    public buyStock1() {
        // Required empty public constructor -anscheinend nicht required loL!
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }
    }

//onCreateView_________________________________________________________________________________________________________
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { // Inflate the layout for this fragment
        View viewwww = inflater.inflate(R.layout.fragment_buy_stock1, container, false);

//kaufen-button
        aktienanzahl = viewwww.findViewById(R.id.putinamountofsharesid);
        buybutton = viewwww.findViewById(R.id.buybuttonid);
        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction BUYTOHOME = getFragmentManager().beginTransaction();
                BUYTOHOME.replace(R.id.unteresfragment_containerid, new homeStock1(), "BACKTOHOMEFROMBUY").commit();
            }
        });
//zurück-butón
        buttonfragmentbuyzurueck = viewwww.findViewById(R.id.zurueckbuttonbuyfragmentid);
        buttonfragmentbuyzurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmenttransactionBACKTOHOME = getFragmentManager().beginTransaction();
                fragmenttransactionBACKTOHOME.replace(R.id.unteresfragment_containerid, new homeStock1(), "BACKTOHOMEFROMBUY").commit();
            }
        });
//autom. price calculator
        aktienanzahl = viewwww.findViewById(R.id.putinamountofsharesid);
        aktienanzahl.requestFocus(); //damit das feld schon offen ist
        aktienpreis = showStock.stockValue;
        aktienkaufpreis = viewwww.findViewById(R.id.buycalculatorid);

        TextWatcher ENDVERAENDERER3000 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!aktienanzahl.getText().toString().equals("")) {
                    int temp1 = Integer.parseInt(aktienanzahl.getText().toString());
                    aktienkaufpreis.setText(String.valueOf(temp1 * aktienpreis));
                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        };
        aktienanzahl.addTextChangedListener(ENDVERAENDERER3000);
//TODO Rechnung in beide Richtungen: aus dem Ausrechnungfeld ein Edittext machen und da soll auch eingetragen werden können, wie viel Geld man ausgeben will - wobei dann die Aktienanzahl berechnet wird (könnte irgendwie achieved werden, indem man einen focuslistener auf die edittextes packt, aber das hat nicht funktioniert) --> wenn ich es ändere, muss ganz oben auch TextView zu EditText umgewandelt werden


// funktioniert momentan nicht, weil code in showStock nicht richtig abläuft
        verfuegbarerbestandanzeige = viewwww.findViewById(R.id.verfuegbarerbestandanzeigeid);
        verfuegbarerbestand = showStock.verfuegbarerDepotbestand;
        verfuegbarerbestandanzeige.setText(String.valueOf(verfuegbarerbestand)); //int verfuegbarerbestand muss als String angezeigt werden, sonst kackt es ab1 (btw: hier hätte auch direkt setText(showStock.verfuegbarerDepotbestand); reinkommen können)







        return viewwww;
    }





//______________________________________________________________________________________END



}

















/*package com.example.tradeview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/*
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link buyStock1#newInstance} factory method to
 * create an instance of this fragment.
 */
/*
public class buyStock1 extends Fragment {

    // TODO: Rename and change types and number of parameters
    private static final String TEXT = "sinnlosertext";    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private String mText;
    private OnFragmentInteractionListener mListener;
    private Button buybutton;
    private Button buttonfragmentbuyzurueck;
    private EditText putinamountofsharesfragmentbuy;

    //sinnlosertext-Weiterleitung_________________________________________________________________________________________________________
    public buyStock1() {
        // Required empty public constructor -anscheinend nicht required loL!
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sinnlosertext Parameter 1.
     * @return A new instance of fragment buyStock1.
     */
    // TODO: Rename and change types and number of parameters
  /*  public static buyStock1 newInstance(String sinnlosertext) {
        buyStock1 buyfragmentLOL = new buyStock1();
        Bundle args = new Bundle();
        args.putString(TEXT, sinnlosertext);
        buyfragmentLOL.setArguments(args);
        return buyfragmentLOL;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(TEXT);
        }
    }


    //onCreateView_________________________________________________________________________________________________________
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewwww = inflater.inflate(R.layout.fragment_buy_stock1, container, false);

        putinamountofsharesfragmentbuy = viewwww.findViewById(R.id.putinamountofsharesEdittextid);
        buybutton = viewwww.findViewById(R.id.buybuttonid);
        putinamountofsharesfragmentbuy.setText(mText); //mText gets provided mText over the newinstance method
        putinamountofsharesfragmentbuy.requestFocus(); // ?
        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendBackText = putinamountofsharesfragmentbuy.getText().toString();
                sendBack(sendBackText);
                //button click: sendBack gets called and passes the content of putinamountofsharesfragmentbuy, then sendBack-method (unten) will call onFragmentInteraction on our mListener (which is showStock.java)
                //and passes the sendBackText to it, then showStock.java is going to implement onFragmentInteraction (ganz unten)
            }
        });

        buttonfragmentbuyzurueck = viewwww.findViewById(R.id.zurueckbuttonbuyfragmentid);
        buttonfragmentbuyzurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmenttransactionBACKTOHOME = getFragmentManager().beginTransaction();
                fragmenttransactionBACKTOHOME.replace(R.id.unteresfragment_containerid, new homeStock1(), "BACKTOHOMEFROMBUY").commit();
            }
        });

        return viewwww;
    }






    //7 button für weiterleiten des eingegebenen AMOUNTS (die folgenden kommen von codinginflow (mglw. outdated code ... bei mir kamen diese dummy variables nicht)
    // TODO: Rename method, update argument and hook method into UI event
    public void sendBack(String sendBackText) {
        if (mListener != null) { mListener.onFragmentInteraction(sendBackText); }
    }
    //onAttach and onDetach sind für das Weiterleiten des Textes irgendwie zuständig...
    @Override
    public void onAttach(Context contexttt) {
        super.onAttach(contexttt);
        if (contexttt instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) contexttt;
        } else {
            throw new RuntimeException(contexttt.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String sendbackText);
    }
//______________________________________________________________________________________END



}
*/