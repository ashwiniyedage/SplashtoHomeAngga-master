package com.example.anggarisky.splashtohomeangga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button zero,one,two,three,four,five,six,seven,eight,nine,add,sub,div,mul,clr,eql;

    private EditText info;
    private TextView result;
    private final char ADDITION='+';
    private final char SUBSTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char EQU='0';
    private  Double val1=Double.NaN;
    private  Double val2;
    private char ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setupView();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");              //"+" is used to concatenate two numbers and getText() is used to get privious value or number
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() +"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() +"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ch=ADDITION;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
                info.setEllipsize(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ch=SUBSTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
                info.setEllipsize(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ch=MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
                info.setEllipsize(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ch=DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
                info.setEllipsize(null);
            }
        });
        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ch=EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" +String.valueOf(val1));
                info.setText(null);
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0)
                {
                    CharSequence name=info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else
                {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

    }
    private void setupView() {
        info = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.editText2);
        zero = (Button) findViewById(R.id.button12);
        one = (Button) findViewById(R.id.button2);
        two = (Button) findViewById(R.id.button3);
        three = (Button) findViewById(R.id.button4);
        four = (Button) findViewById(R.id.button5);
        five = (Button) findViewById(R.id.button6);
        six = (Button) findViewById(R.id.button7);
        seven = (Button) findViewById(R.id.button8);
        eight = (Button) findViewById(R.id.button9);
        nine = (Button) findViewById(R.id.button10);
        clr = (Button) findViewById(R.id.button11);
        eql = (Button) findViewById(R.id.button13);
        mul = (Button) findViewById(R.id.button14);
        add = (Button) findViewById(R.id.button15);
        sub = (Button) findViewById(R.id.button16);
        div = (Button) findViewById(R.id.button);
    }
    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());
            switch (ch) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBSTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(info.getText().toString());
        }


    }
}
