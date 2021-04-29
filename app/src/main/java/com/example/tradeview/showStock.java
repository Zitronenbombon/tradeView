package com.example.tradeview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class showStock extends AppCompatActivity { //implements buyStock1.OnFragmentInteractionListener
    Button buttonTag;
    Button buttonWoche;
    Button buttonMonat;
    Button buttonDreiMonate;
    Button buttonSechsMonate;
    Button buttonJahr;
    Button buttonMax;
    ImageButton buttonGrapheinstellen;
    Button buttonKaufen;
    Button buttonVerkaufen;
    Button zurueckbuttonshowstock;
    TextView stockChange;
    //variables for fragment
    private FrameLayout fragmentContainer;
    //brauche ich eig nicht
    private EditText buysinnlosesedittextlol;
    private TextView sinnlosetextanzeige;
    //FragmentTransaction mFragmenttransaction;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userid;
    //importieren von STOCKVALUE (eines bestimmten stocks momentan noch [MrBeast]) und DEPOTWERT
    static int stockValue;
    static int verfuegbarerDepotbestand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stock);
        //DIESE ACTIVIITY MUSS JE DANACH, OB EIN USER DIE GEZEIGTE AKTIE BESITZT ODER NICHT, ENTWEDER KAUFEN/VERKAUFEN ANZEIGEN ODER KAUFEN/SHORTEN
//------------------------------------------------
        fragmentContainer = (FrameLayout) findViewById(R.id.unteresfragment_containerid);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userid = fAuth.getCurrentUser().getUid();

        DocumentReference documentReferenceUser = fStore.collection("user").document(userid);
        documentReferenceUser.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                verfuegbarerDepotbestand = documentSnapshot.getLong("saldo").intValue();
                System.out.println(documentSnapshot.getLong("saldo").intValue());
            }
        });
        System.out.println("maggi ist " + verfuegbarerDepotbestand); //wird ausgeführt bevor verfuegbarerDepobestand oben eingereicht wird
        System.out.println("user id ist " + userid);

        DocumentReference documentReferenceStock = fStore.collection("stocks").document("Ba6WytX14u3gReyDGtEn");
        documentReferenceStock.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                //  balance.setText(getResources().getString(R.string.saldoText) + ": " + documentSnapshot.getLong("value").intValue());
                stockValue = documentSnapshot.getLong("value").intValue();

            }
        });






//stock und preis sollen standardmäßig auf TAG eingestellt sein, wenn man die seite das 1. mal öffnet (ansonsten mit onResume konfiguration beibehalten


/*
//Button tag
        stockChange = (TextView) findViewById(R.id.stockchangeid);
        buttonTag = (TextView) findViewById(R.id.tagid);
        buttonTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if() {//stockChange wird NICHT pro Tag angezeigt
                    stockChange.setText();//hier muss der stockChange pro TAG von der datenbank eingelesen werden
                }
            }
        });
//Button woche
        buttonWoche = (TextView) findViewById(R.id.wocheid);
        buttonWoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //auf knopfdruck soll hier der graph zur WOCHENANZEIGE geändert werden (oder wenn es schon ist, gar nichts passieren)
            }
        });
//Button monat
        buttonMonat = (TextView) findViewById(R.id.monatid);
        buttonMonat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //auf knopfdruck soll hier der graph zur MONATSANZEIGE geändert werden (oder wenn es schon ist, gar nichts passieren)
            }
        });
//Button 3monate
        buttonDreiMonate = (TextView) findViewById(R.id.dreimonateid);
        buttonDreiMonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //auf knopfdruck soll hier der graph zur 3 MONATSANZEIGE geändert werden (oder wenn es schon ist, gar nichts passieren)
            }
        });
//Button 6monate
        buttonSechsMonate = (TextView) findViewById(R.id.sechsmonateid);
        buttonSechsMonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //auf knopfdruck soll hier der graph zur 6 MONATSANZEIGE geändert werden (oder wenn es schon ist, gar nichts passieren)
            }
        });
//Button jahr
        buttonJahr = (TextView) findViewById(R.id.jahrid);
        buttonJahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //auf knopfdruck soll hier der graph zur JAHRANZEIGE geändert werden (oder wenn es schon ist, gar nichts passieren)
            }
        });
//Button max
        buttonMax = (TextView) findViewById(R.id.maxid);
        buttonMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //auf knopfdruck soll hier der graph zur MAXANZEIGE geändert werden (oder wenn es schon ist, gar nichts passieren)
            }
        });




//Button kaufen/verkaufen
        buttonKaufen = (ImageButton) findViewById(R.id.kaufenid);
        buttonKaufen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(showStock.this, buyStock.class));
            }
        });
*/


//zurückbutton zur mainactivity
        zurueckbuttonshowstock = (Button) findViewById(R.id.zurueckbuttonshowstockid);
        zurueckbuttonshowstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(showStock.this,MainActivity.class));
            }
        });




//home fragment:
        FragmentTransaction mFragmenttransactionhome = getSupportFragmentManager().beginTransaction(); //assigning of the fragment transaction
        homeStock1 HOMEfragment = new homeStock1();
        mFragmenttransactionhome.replace(R.id.unteresfragment_containerid, HOMEfragment, "HOMEFRAGMENT"); //replace the fragmentcontainer with the fragment :D so that the homefragment shows when starting activity
        mFragmenttransactionhome.commit();



    }

}












/*
//buy fragment:
        buttonKaufen = (Button) findViewById(R.id.kaufenid);
        buysinnlosesedittextlol = (EditText) findViewById(R.id.sinnlosesedittextid);
        sinnlosetextanzeige = (TextView) findViewById(R.id.sinnlosetextanzeigeid);
        buttonKaufen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //überprüfen, ob das buy-fragment schon angezeigt wird (find by tag)
                //   buyStock1 mBuy = (buyStock1) getSupportFragmentManager().findFragmentByTag("BUYFRAGMENT");
                //   if(mBuy != null && mBuy.isVisible()) {}
                //    else { String sinnlosertext = buysinnlosesedittextlol.getText().toString();
                    //   openFragmentbuy(sinnlosertext); }
                String sinnlosertext = buysinnlosesedittextlol.getText().toString();
                openFragmentbuy(sinnlosertext);
            }
        });
//sel fragment:
        buttonVerkaufen = (Button) findViewById(R.id.verkaufenid);

        buttonVerkaufen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //überprüfen, ob das sell-fragment schon angezeigt wird (find by tag)
                //  sellStock1 mSell = (sellStock1) getSupportFragmentManager().findFragmentByTag("SELLFRAGMENT");
                //     if(mSell != null && mSell.isVisible()) {}
                //  else { openFragmentsell(); }
               openFragmentsell();
            }
        });
public void openFragmentbuy(String sinnlosertext) {
    //intiierung
    buyStock1 BUYfragment = buyStock1.newInstance(sinnlosertext); //buy-fragment wird initiiert mit newInstance-method (, die Information weiterleitet, also hier: sinnlosertext)
    FragmentManager fragmentManagerBUY = getSupportFragmentManager(); //fragment-manager
    FragmentTransaction fragmenttransactionBUY = fragmentManagerBUY.beginTransaction(); //fragment-transaction
    //animations
    fragmenttransactionBUY.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right); //vorher war alles in der klammer 2 mal, damit auch beim back button passiert ? oder so
    //fragment öffnen
    fragmenttransactionBUY.addToBackStack(null);//fragment wird in backstack gepackt und kann remembered werden
    fragmenttransactionBUY.add(R.id.unteresfragment_containerid, BUYfragment, "BUYFRAGMENT").commit();
}
    public void openFragmentsell() {
        sellStock1 SELLfragment = new sellStock1();                                                                                            //sell-fragment wird initiiert
        FragmentTransaction fragmenttransactionSELL;
        fragmenttransactionSELL = getSupportFragmentManager().beginTransaction();                                                                 //fragment-transaction
        fragmenttransactionSELL.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);                                                //animations
        fragmenttransactionSELL.add(R.id.unteresfragment_containerid, SELLfragment, "BUYFRAGMENT").commit();

        //  mFragmenttransaction.replace(R.id.unteresfragment_containerid, SELLfragment, "SELLFRAGMENT").commit();                           //replace fragment


  /*  //intiierung
        sellStock1 SELLfragment = new sellStock1(); //sell-fragment wird initiiert
        FragmentManager fragmentmanagerSELL = getSupportFragmentManager(); //fragment-manager
        FragmentTransaction fragmenttransactionSELL = fragmentmanagerSELL.beginTransaction(); //fragment-transaction
    //animations
        fragmenttransactionSELL.setCustomAnimations(R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right);
    //fragment öffnen
        fragmenttransactionSELL.addToBackStack(null);
        mFragmenttransaction.replace(R.id.unteresfragment_containerid, SELLfragment, "SELLFRAGMENT").commit();

 //       mFragmenttransaction.replace(R.id.unteresfragment_containerid, SELLfragment, "SELLFRAGMENT"); //replace the fragmentcontainer with the fragment :D so that the homefragment shows when starting activity
   //     fragmenttransactionSELL.commit();

    }

    @Override
    public void onFragmentInteraction(String sendbackText) {
        sinnlosetextanzeige.setText(sendbackText);
        onBackPressed();
    }
*/