package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostActivity extends AppCompatActivity {

    private TextView textos;
    private Button back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        textos = findViewById(R.id.textos);
        back = findViewById(R.id.back);

        new Thread(
                () -> {

                    String base="192.168.0.";

                    for (int i=1;i<255;i++){

                        String ip1= base+i;

                        try {


                            InetAddress inet = InetAddress.getByName(ip1);
                            boolean conectado = inet.isReachable(3000);

                            runOnUiThread(
                                    ()->{
                                        if (conectado){
                                            textos.append("ip1\n");

                                        }else {
                                           // verifica.append("perdido\n");

                                        }
                                    }
                            );

                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                }
        ).start();

        back.setOnClickListener(

                v -> {

                    Intent i= new Intent(this,MainActivity.class);
                    startActivity(i);
                    finish();

                }
        );



    }
}