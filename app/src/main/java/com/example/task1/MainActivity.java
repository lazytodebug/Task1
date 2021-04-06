package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        clevertapDefaultInstance.pushEvent("Product viewed");
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
    }
    public void onLogin(View view){
        EditText txtUser = findViewById(R.id.edtTextName);
        EditText txtMail = findViewById(R.id.edtTextEmail);
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", txtUser.getText().toString());    // String
        profileUpdate.put("Identity", 61026032);      // String or number
        profileUpdate.put("Email", txtMail.getText().toString()); // Email address of the user
        profileUpdate.put("Phone", "+14155551234");   // Phone (with the country code, starting with +)
        profileUpdate.put("Gender", "M");             // Can be either M or F
        profileUpdate.put("DOB", new Date());         // Date of Birth. Set the Date object to the appropriate value first
        // optional fields. controls whether the user will be sent email, push etc.
        profileUpdate.put("MSG-email", false);        // Disable email notifications
        profileUpdate.put("MSG-push", true);          // Enable push notifications
        profileUpdate.put("MSG-sms", false);          // Disable SMS notifications
        profileUpdate.put("MSG-whatsapp", true);      // Enable WhatsApp notifications
        ArrayList<String> stuff = new ArrayList<String>();
        stuff.add("bag");
        stuff.add("shoes");
        profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
        String[] otherStuff = {"Jeans","Perfume"};
        profileUpdate.put("MyStuff", otherStuff);                   //String Array
        CleverTapAPI.getDefaultInstance(getApplicationContext()).onUserLogin(profileUpdate);

    }

    public void onTest(View view){
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        clevertapDefaultInstance.pushEvent("Test");
    }
}