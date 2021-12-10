package com.example.ejintentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static   final int LLAMADA_TELEFONICA =1;//cte asociada a la llamada directa

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
                //comprobar que existe activity capaz de dar respuesta
                if(i.resolveActivity(getPackageManager())!=null){
                    startActivity(i);
                }else{
                    Toast.makeText(this, "NO HAY ACTIVITY DISPONIBLE", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.button_dial:
                //visualizar el dial SIN numero premarcado
                i = new Intent(Intent.ACTION_DIAL);
                startActivity(i);
                break;
            case R.id.button_dial_premarcado:
                //visualizar el dial CON numero premarcado
                i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:(+34)657050214"));
                startActivity(i);
                break;
            case R.id.button_navegador:
                //action + URI
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.xunta.gal"));
                //comprobar que existe activity capaz de dar respuesta
                if(i.resolveActivity(getPackageManager())!=null){
                    startActivity(i);
                }else{
                    Toast.makeText(this, "NO HAY ACTIVITY DISPONIBLE", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.button_mapa:
                //action + URI
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:42.25,-8.68?z=15"));
                //comprobar que existe activity capaz de dar respuesta
                if(i.resolveActivity(getPackageManager())!=null){
                    startActivity(i);
                }else{
                    Toast.makeText(this, "NO HAY ACTIVITY DISPONIBLE", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.button_llamada:
                //realizar una llamda de forma directa
                //
                int permiso = checkSelfPermission(Manifest.permission.CALL_PHONE);
                if(permiso== PackageManager.PERMISSION_GRANTED){

                }

                //comprobar que existe activity capaz de dar respuesta
                if(checkSelfPermission(Manifest.permission.CALL_PHONE)){
                    i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:(+34)657050214"));
                    startActivity(i);
                }else{
                    //Solicitamos al sistema que muestre el cuadro de dialogo
                    requestPermissions(new String[]{Man});
                }




                break;







        }


    }
}