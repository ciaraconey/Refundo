package com.example.janeeastwood123.refundo;

import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;



/**
 * Created by janeeastwood123 on 11/03/2017.
 */

public class Scan extends MainActivity {

    Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan);

        b1 = (Button) findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent scan = new Intent(Scan.this, Capture.class);
                startActivity(scan);



            }

        });

    }

    }


