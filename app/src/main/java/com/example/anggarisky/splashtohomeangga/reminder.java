package com.example.anggarisky.splashtohomeangga;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

public class reminder extends AppCompatActivity {

    Button b1,b2;
    CalendarView c;
    String s,s1;
    DatabaseHelper db;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        c=findViewById(R.id.calendarView);
        e1=findViewById(R.id.editText);
        s1=e1.getText().toString();
        db=new DatabaseHelper(this);
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                s=i+"/"+i1+"/"+i2;
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                if(db.insertdata(s,s1)){
                    // Toast.makeText(MainActivity.this,"We Remember Everything",Toast.LENGTH_LONG).show();
                    Toast.makeText(reminder.this,"We remember everything",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(reminder.this,"Something went Wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void viewAll(View view){
        //Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_LONG).show();
        Cursor cursor = db.getAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(reminder.this,"No item found",Toast.LENGTH_LONG).show();
            return;
        }
        else {
            Toast.makeText(reminder.this,"item found",Toast.LENGTH_LONG).show();
        }
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()){
            buffer.append("Date: "+cursor.getString(0)+"\n");
            buffer.append("Event: "+cursor.getString(1)+"\n");
        }
        showMessage("All data", buffer.toString());
    }
    private void showMessage(String title, String message){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();


    }


}
