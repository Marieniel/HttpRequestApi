package com.example.marieniel.httprequestapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private EditText EditTextUname, EditTextPass;
    private Button button;
    private OkHttpClient client;
    private String myUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.textview);
        button = findViewById(R.id.button);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        EditTextUname = findViewById(R.id.editTextUname);
        EditTextPass = findViewById(R.id.editTextPass);
        myUrl = "https://payroll.civicmdsg.com.ph/payrollapi/api/employees/?employeeNo="+ EditTextUname.getText().toString()+ "&password=" + EditTextPass.getText().toString();

        getWebservice();



    }
    });

    client = new OkHttpClient();

    }

    private void getWebservice(){
        final Request request = new Request.Builder().url(myUrl).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextViewResult.setText("Fail");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                     public void run() {
                        try {

                             mTextViewResult.setText(response.body().string());

                             if (mTextViewResult.getText().equals("true")){
                                 //call home page Activity
                                 homeactivity();
                             }





                        } catch (IOException ioe) {

                        }
                    }
                });
            }
        });
    }


    //show home page
    public void homeactivity(){
        Intent myhomeintent = new Intent (this,HomeActivity.class);
        startActivity(myhomeintent);
        finish();
    }


}
