package com.example.numberguessinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView textViewGuess;
    TextView textViewChance;
    TextView textViewHint;
    EditText editTextAns;
    Button buttonConfirm;
    boolean twoDigits, threeDigits, fourDigits;

    Random r=new Random();
    int random;

    int remainChance=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewGuess=findViewById(R.id.textViewguess);
        textViewChance=findViewById(R.id.textViewchance);
        textViewHint=findViewById(R.id.textViewhint);
        editTextAns=findViewById(R.id.editTextAnswer);
        buttonConfirm=findViewById(R.id.buttonConfirm);

        twoDigits=getIntent().getBooleanExtra("Two",false);
        threeDigits=getIntent().getBooleanExtra("Three",false);
        fourDigits=getIntent().getBooleanExtra("Four",false);

        if(twoDigits)
            random=r.nextInt(90)+10;
        else if(threeDigits)
            random=r.nextInt(900)+100;
        else if(fourDigits)
            random=r.nextInt(9000)+1000;

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String guessNumber = editTextAns.getText().toString();
                    if (guessNumber.equals(""))
                        Toast.makeText(GameActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
                    else {
                        textViewGuess.setVisibility(View.VISIBLE);
                        textViewChance.setVisibility(View.VISIBLE);
                        textViewHint.setVisibility(View.VISIBLE);

                        remainChance--;

                        int Num = Integer.parseInt(guessNumber);

                        if (random == Num) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(GameActivity.this);
                            alertDialog.setTitle("HURRAY").setMessage("Your guess is correct. Do you want to play again?").setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);

                                }
                            }).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }).show();
                        } else if (random < Num) {
                            textViewGuess.setText("Your Last Guess : " + guessNumber);
                            textViewChance.setText("Chance Remaining : " + remainChance);
                            textViewHint.setText("Hint: Decrease your guess");
                        } else if (random > Num) {
                            textViewGuess.setText("Your Last Guess : " + guessNumber);
                            textViewChance.setText("Chance Remaining : " + remainChance);
                            textViewHint.setText("Hint: Increase your guess");
                        }
                    }

                if(remainChance<1) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(GameActivity.this);
                    alertDialog.setTitle("Oops!!").setMessage("Your Chance are Over. Do you want to play again?").setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);

                        }
                    }).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(GameActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }).show();

                }
            }

        });

    }
}