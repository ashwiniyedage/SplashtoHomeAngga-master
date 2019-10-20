package com.example.anggarisky.splashtohomeangga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView bgapp, clover;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;
    ImageButton btimer;
    Button cl3;
    ImageButton bcalculator;
    ImageButton breminder;
    ImageButton bnotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);



        bgapp =  findViewById(R.id.bgapp);
        clover = findViewById(R.id.clover);
        textsplash = findViewById(R.id.textsplash);
        texthome = findViewById(R.id.texthome);
        menus = findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);


        btimer = findViewById(R.id.btimer);
        btimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,timer.class);
                startActivity(intent);
            }
        });

        bcalculator=(ImageButton) findViewById(R.id.bcalculator);
        bcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        breminder=(ImageButton)findViewById(R.id.breminder);
        breminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        bnotes=(ImageButton)findViewById(R.id.bnotes);
        bnotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opennotes();
            }
        });


  ;
    }
        public  void opennotes(){
        Intent intent=new Intent(this,notes.class);
        startActivity(intent);
        }

        public void openActivity2(){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
        }


    public void openActivity3(){
        Intent intent=new Intent(this,reminder.class);
        startActivity(intent);
    }

}
