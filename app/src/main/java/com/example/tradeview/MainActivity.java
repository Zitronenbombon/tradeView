package com.example.tradeview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    Button losgehtes;


    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userid;
    static int verfuegbarerDepotbestand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        losgehtes = (Button) findViewById(R.id.losgehtesid);
        losgehtes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,showStock.class));
            }
        });





        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userid = fAuth.getCurrentUser().getUid();
        System.out.println("user id in main ist " + userid);

        DocumentReference documentReferenceUser = fStore.collection("user").document(userid);
        documentReferenceUser.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                verfuegbarerDepotbestand2 = documentSnapshot.getLong("saldo").intValue();
                System.out.println(documentSnapshot.getLong("saldo").intValue());
                System.out.println(verfuegbarerDepotbestand2);

            }
        });
        System.out.println("saldo in main ist " + verfuegbarerDepotbestand2);


    }




    public void logout (View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}