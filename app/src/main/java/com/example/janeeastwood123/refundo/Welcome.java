package com.example.janeeastwood123.refundo;

/**
 * Created by janeeastwood123 on 11/03/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Welcome extends MainActivity {

    Button b1, b4, b2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        b1 = (Button) findViewById(R.id.button1);
        b4 = (Button) findViewById(R.id.button4);
        b2 = (Button) findViewById(R.id.button2);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // intent and start activity used to advance the page, uri used to redirect to webpage
                Intent welcome = new Intent(Welcome.this, Scan.class);
                startActivity(welcome);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // intent and start activity used to advance the page, uri used to redirect to webpage
                Intent returns = new Intent(Welcome.this, Returns.class);
                startActivity(returns);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // intent and start activity used to advance the page, uri used to redirect to webpage
                Intent account = new Intent(Welcome.this, MyAccount.class);
                startActivity(account);

            }
        });
    }
    }




