package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //Layout layout;
    RadioGroup radioGroup;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //layout =findViewById(R.id.layoutmain);
        radioGroup=findViewById(R.id.radiogroupmain);
        radioButton2=findViewById(R.id.radioButtontwo);
        radioButton3=findViewById(R.id.radioButtonthree);
        radioButton4=findViewById(R.id.radioButtonfour);
        button=findViewById(R.id.buttonmain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,GameActivity.class);
                if(!radioButton2.isChecked()&&!radioButton3.isChecked()&&!radioButton4.isChecked())
                    Snackbar.make(view,"Please choose an option",Snackbar.LENGTH_LONG).show();
                else {
                    if (radioButton2.isChecked())
                        intent.putExtra("Two", true);
                    else if (radioButton3.isChecked())
                        intent.putExtra("Three", true);
                    else if (radioButton4.isChecked())
                        intent.putExtra("Four", true);
                    startActivity(intent);
                }
            }
        });

    }
}