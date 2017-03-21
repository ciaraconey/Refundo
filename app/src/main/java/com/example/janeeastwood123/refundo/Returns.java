package com.example.janeeastwood123.refundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by janeeastwood123 on 12/03/2017.
 */

public class Returns extends MainActivity {

    TextView tx1, tx2, tx3;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.returns);


        tx1 = (TextView) findViewById(R.id.asos);
        tx2 = (TextView) findViewById(R.id.newlook);
        tx3 = (TextView) findViewById(R.id.topshop);


        tx1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {


                Intent asos = new Intent(Returns.this, Tracking.class);
                startActivity(asos);


            }
        });

        tx1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {

                // when the TextView is clicked the user is brought to activity_2 (forgotten password page)
                Intent forgot = new Intent(Returns.this, Tracking.class);
                startActivity(forgot);

            }

        });

        tx2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {


                Intent signup = new Intent(Returns.this, Tracking.class);
                startActivity(signup);

            }

        });

        tx3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {


                Intent signup = new Intent(Returns.this, Tracking.class);
                startActivity(signup);

            }

        });

    }
}






