package com.example.ejintentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view) {

        Intent i;


        switch (view.getId()){

            case R.id.button_contactos:
                //action + URI
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(i);
                break;







        }


    }
}