package com.example.janeeastwood123.refundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by janeeastwood123 on 13/03/2017.
 */

public class Registration extends MainActivity {

        EditText editTextFirstName, editTextLastName, editTextUserName, editTextEmail, editTextPassword, editTextConfirmPassword;
        Button btnCreateAccount;

        LoginDataBaseAdapter loginDataBaseAdapter;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.registration);

            // get Instance of Database Adapter
            loginDataBaseAdapter=new LoginDataBaseAdapter(this);
            loginDataBaseAdapter=loginDataBaseAdapter.open();

            // Get References of Views
            editTextFirstName=(EditText)findViewById(R.id.fname);
            editTextLastName=(EditText)findViewById(R.id.sname);
            editTextUserName=(EditText)findViewById(R.id.uname);
            editTextEmail=(EditText)findViewById(R.id.email);
            editTextPassword=(EditText)findViewById(R.id.EditText2);
            editTextConfirmPassword=(EditText)findViewById(R.id.EditText3);

            btnCreateAccount=(Button)findViewById(R.id.button);
            btnCreateAccount.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    String userName=editTextUserName.getText().toString();
                    String password=editTextPassword.getText().toString();
                    String confirmPassword=editTextConfirmPassword.getText().toString();

                    // check if any of the fields are vaccant

                    if( userName.equals("")||password.equals("")||confirmPassword.equals(""))
                    {
                        editTextUserName.setError( "Username is required!" );
                        editTextPassword.setError( "Password is required!" );
                        editTextConfirmPassword.setError( "Confirm Password is required!" );
                        return;
                    }
                    // check if both password matches
                   else if(!password.equals(confirmPassword))
                    {
                        Toast.makeText(getApplicationContext(), "Password does not match!", Toast.LENGTH_LONG).show();
                        return;
                    }

                    else if(!isValidPassword(password))
                    {
                        Toast.makeText(getApplicationContext(), "Password must be at least 6 characters in length", Toast.LENGTH_LONG).show();
                        return;
                    }
                    else
                    {
                        // Save the Data in Database
                        loginDataBaseAdapter.insertEntry(userName, password);
                        Toast.makeText(getApplicationContext(), "Account Created - Please login to use your account ", Toast.LENGTH_LONG).show();
                        Intent login = new Intent(Registration.this, MainActivity.class);
                        startActivity(login);
                    }
                }
            });
        }


    // validating password with retype password
    private boolean isValidPassword(String password) {
        if (password.length() > 6) {
            return true;
        }
        return false;
    }


        @Override
        protected void onDestroy() {
            // TODO Auto-generated method stub
            super.onDestroy();

            loginDataBaseAdapter.close();
        }
}
