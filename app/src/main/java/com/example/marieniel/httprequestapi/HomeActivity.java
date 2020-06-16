package com.example.marieniel.httprequestapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button todayslogsbtton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        todayslogsbtton = findViewById(R.id.button2);

       todayslogsbtton.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {

               //call todays logs page Activity
               todayslogsactivity();

           }
       });

    }


    //show todays logs activity
    public void todayslogsactivity(){
        Intent mytodayslogsintent = new Intent (this,TodayslogsActivity.class);
        startActivity(mytodayslogsintent);
        finish();
    }






}
