package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageview;
    TextView textview;
    Animation animationimage,animationtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageview=findViewById(R.id.imageView2);
        textview=findViewById((R.id.textView));

        animationimage= AnimationUtils.loadAnimation(this,R.anim.imageanimation);
        animationtext=AnimationUtils.loadAnimation(this,R.anim.textanimation);

        imageview.setAnimation(animationimage);
        textview.setAnimation(animationtext);

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        }.start();

    }
}