package com.example.janeeastwood123.refundo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by janeeastwood123 on 22/02/2017.
 */

public class activity_2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView details = (TextView) findViewById(R.id.textView1);
        String information;
        Bundle extras = getIntent().getExtras();
        if (extras != null) { information = extras.getString("details");
            details.setText( "Hi, " + information + ", please reset your password below!");
        }
    }

}

