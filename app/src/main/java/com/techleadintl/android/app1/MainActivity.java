package com.techleadintl.android.app1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etName, etAge, etNote;
    Button btnAdd;
    RecyclerView recyclerView;

    List<Model> itemList = new ArrayList<>();

    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail=(EditText) findViewById(R.id.txt_email);
        etName=(EditText) findViewById(R.id.txt_name);
        etAge=(EditText) findViewById(R.id.txt_age);
        etNote=(EditText) findViewById(R.id.txt_note);

        btnAdd=(Button) findViewById(R.id.btn_add);

        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerger=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManagerger);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter=new MainAdapter(itemList, MainActivity.this);
        recyclerView.setAdapter(adapter);

        //set data


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String e=etEmail.getText().toString();
                String n=etName.getText().toString();
                String a=etAge.getText().toString();
                String no=etNote.getText().toString();

                if (e.isEmpty() || n.isEmpty() || a.isEmpty() || no.isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Please Complete!", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{

                        Model model=new Model(etEmail.getText().toString(),etName.getText().toString(), etAge.getText().toString(), etNote.getText().toString());
                        adapter.add(model);

                  /*     // String email=email_txt.getText().toString();
                       // itemList.add(e);
                        email_txt.setText("");
                       // adapter.notifyItemInserted(itemList.size()-1);
                       // String name=name_txt.getText().toString();
                        itemList.add(n);
                        name_txt.setText("");
                        adapter.notifyItemInserted(itemList.size()-1);
                       // String age=age_txt.getText().toString();
                        itemList.add(a);
                        age_txt.setText("");
                        adapter.notifyItemInserted(itemList.size()-1);
                       // String note=note_txt.getText().toString();
                        itemList.add(no);
                        note_txt.setText("");
                        adapter.notifyItemInserted(itemList.size()-1); */
                    }
                    catch (NumberFormatException e1){

                    }
                }

            }
        });
    }



}