package com.example.a1a1a1.quickcoding01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button min2=(Button)findViewById(R.id.minimum);
        final Button aver2=(Button)findViewById(R.id.average);

        final aver resultaver=new aver();
        final mini resultmini=new mini();


        aver2.setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), String.valueOf(resultaver.getResult()),Toast.LENGTH_LONG).show();
                    }
                }
        );
        min2.setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), String.valueOf(resultmini.getResult()),Toast.LENGTH_LONG).show();

                    }


                }
        );
    }



}
