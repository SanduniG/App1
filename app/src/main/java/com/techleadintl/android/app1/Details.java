package com.techleadintl.android.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView txtEmail, txtName, txtAge, txtNote;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtEmail= findViewById(R.id.txt_email);
        txtName= findViewById(R.id.txt_name);
        txtAge= findViewById(R.id.txt_age);
        txtNote= findViewById(R.id.txt_note);

        btnBack= findViewById(R.id.btn_back);

        Intent intent=getIntent();

        String email=intent.getStringExtra("email");
        txtEmail.setText(email);

        String name=intent.getStringExtra("name");
        txtName.setText(name);

        String age=intent.getStringExtra("age");
        txtAge.setText(age);

        String note=intent.getStringExtra("note");
        txtNote.setText(note);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Details.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}