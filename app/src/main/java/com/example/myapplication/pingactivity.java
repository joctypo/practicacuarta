package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class pingactivity extends AppCompatActivity {



    private Button backk;
    private TextView verifica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingactivity);

        String iplast = getIntent().getExtras().getString("ipfinal");

        backk = findViewById(R.id.backk);
        verifica = findViewById(R.id.verifica);


        new Thread(
                () -> {
                    //IP del computador en la que estoy parado

                    try {
                        //String ip = "127.0.0.1";
                        InetAddress inet = InetAddress.getByName(iplast);
                        for (int i=0;i<5;i++){

                            boolean conectado = inet.isReachable(3000);

                            runOnUiThread(
                                    ()->{
                                        if (conectado){
                                            verifica.append("recibido\n");

                                        }else {
                                            verifica.append("perdido\n");

                                        }
                                    }
                            );

                        }




                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
        ).start();

        backk.setOnClickListener(
                v -> {

                    Intent i= new Intent(this,MainActivity.class);
                    startActivity(i);
                    finish();

                }
        );

    }
}