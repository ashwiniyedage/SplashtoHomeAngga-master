package com.example.anggarisky.splashtohomeangga;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class timer extends AppCompatActivity {

    EditText editText2;
    Button button2;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        editText2 =(EditText) findViewById(R.id.editText2);
        button2=(Button)findViewById(R.id.button2);
        textView2=(TextView)findViewById(R.id.textView2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editText2.getText().toString();
                if(!text.equalsIgnoreCase(""))
                {
                    int secounds =Integer.valueOf(text);
                    CountDownTimer countDownTimer=new CountDownTimer(secounds*1000,1000) {
                        @Override
                        public void onTick(long millis) {
                            textView2.setText("secounds:"+ (int) (millis/1000));


                        }

                        @Override
                        public void onFinish() {
                        textView2.setText("finished");
                        }
                    }.start();
                }


            }
        });
    }
}
