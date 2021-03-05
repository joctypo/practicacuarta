package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private EditText ip1;
    private EditText ip2;
    private EditText ip3;
    private EditText ip4;
    private Button ping;
    private Button host;
    private TextView miip;
    private TextView numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip1 = findViewById(R.id.ip1);
        ip2 = findViewById(R.id.ip2);
        ip3 = findViewById(R.id.ip3);
        ip4 = findViewById(R.id.ip4);
        ping = findViewById(R.id.ping);
        host = findViewById(R.id.host);
        miip = findViewById(R.id.miip);
        numero = findViewById(R.id.numero);

        ping.setOnClickListener(
                v -> {

                    String ip11= ip1.getText().toString();
                    String ip12= ip2.getText().toString();
                    String ip13= ip3.getText().toString();
                    String ip14= ip4.getText().toString();
                    String ipf = ip11+"."+ip12+"."+ip13+"."+ip14;

                    Intent i= new Intent(this,pingactivity.class);
                    i.putExtra("ipfinal",ipf);
                    startActivity(i);


                }
        );

        host.setOnClickListener(
                v -> {


                    Intent i= new Intent(this,HostActivity.class);
                    startActivity(i);



                }
        );



    }
}