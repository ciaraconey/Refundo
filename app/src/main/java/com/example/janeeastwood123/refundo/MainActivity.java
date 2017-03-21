package com.example.janeeastwood123.refundo;

import android.graphics.Color;
import android.net.Uri;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends Activity {
    EditText ev1, ev2;
    Button b1, b2;
    TextView tx, tx4, tx5;
    int counter = 3;
    CheckBox showPassword;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a instance of SQLite Database
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Declaring classes from activity_main.xml
        b1 = (Button) findViewById(R.id.button);
        ev1 = (EditText) findViewById(R.id.EditText1);
        ev2 = (EditText) findViewById(R.id.EditText2);
        showPassword = (CheckBox) findViewById(R.id.showPassword);

        b2 = (Button) findViewById(R.id.button2);
        tx = (TextView) findViewById(R.id.textView3);
        tx.setVisibility(View.GONE);
        tx4 = (TextView) findViewById(R.id.textView4);
        tx5 = (TextView) findViewById(R.id.textView5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get The User name and Password
                String userName = ev1.getText().toString();
                String password = ev2.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if (password.equals(storedPassword)) {
                    Toast.makeText(getApplicationContext(),
                            "Successfully logged in to Refundo", Toast.LENGTH_SHORT).show();

                    // intent and start activity used to advance the page, uri used to redirect to webpage
                    Intent welcome = new Intent(MainActivity.this, Welcome.class);
                    startActivity(welcome);

                } else {

                    //if the credentials are incorrect, a toast will appear showing an error message
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",
                            Toast.LENGTH_SHORT).show();

                    //if the credentials are incorrect, both the username and password field will shake to alert the user
                    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                    ev1.startAnimation(shake);
                    ev2.startAnimation(shake);
                    // if the credentials are incorrect, decrement the counter, once the counter becomes 0 disable the login button
                    tx.setVisibility(View.VISIBLE);
                    tx.setTextColor(Color.RED);
                    counter--;
                    tx.setText(Integer.toString(counter));

                    // disable the login button once the counter reaches 0
                    if (counter == 0) {
                        b1.setEnabled(false);
                        b1.setTextColor(Color.GRAY);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // this is the handler for when the user clicks on the checkbox
        showPassword.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed to checked.
                if (!isChecked) {
                    // show password
                    ev2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    ev2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        tx4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {

                // when the TextView is clicked the user is brought to activity_2 (forgotten password page)
                Intent forgot = new Intent(MainActivity.this, activity_2.class);
                startActivity(forgot);

            }

        });

        tx5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {


                Intent signup = new Intent(MainActivity.this, Registration.class);
                startActivity(signup);

            }

        });


    }
}



