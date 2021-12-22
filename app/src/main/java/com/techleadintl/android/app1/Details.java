package com.techleadintl.android.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView txtEmail, txtName, txtAge, txtNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtEmail=(TextView) findViewById(R.id.txt_email);
        txtName=(TextView) findViewById(R.id.txt_name);
        txtAge=(TextView) findViewById(R.id.txt_age);
        txtNote=(TextView) findViewById(R.id.txt_note);

        Intent intent=getIntent();

        String email=intent.getStringExtra("email");
        txtEmail.setText(email);

        String name=intent.getStringExtra("name");
        txtName.setText(name);

        String age=intent.getStringExtra("age");
        txtAge.setText(age);

        String note=intent.getStringExtra("note");
        txtNote.setText(note);
    }
}