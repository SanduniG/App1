package com.techleadintl.android.app1;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {

    List<Model> itemList;
    Context context;


    public MainAdapter(List<Model> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    public void add(Model item) {
        this.itemList .add(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        Holder holder=new Holder(view);

        return new Holder(view).linkAdapter(this);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder,int position) {

        holder.email.setText(itemList.get(position).getEmail());
        holder.name.setText(itemList.get(position).getName());
        holder.age.setText(itemList.get(position).getAge());
        holder.note.setText(itemList.get(position).getNote());

        //update

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog= new Dialog(context);
                dialog.setContentView(R.layout.update_dialog);

                EditText email=dialog.findViewById(R.id.txt_email);
                EditText name=dialog.findViewById(R.id.txt_name);
                EditText age=dialog.findViewById(R.id.txt_age);
                EditText note=dialog.findViewById(R.id.txt_note);

                Button add=dialog.findViewById(R.id.btn_add);

                TextView title=dialog.findViewById(R.id.txt_title);
                title.setText("Update User");

                email.setText(itemList.get(holder.getAdapterPosition()).getEmail());
                name.setText(itemList.get(holder.getAdapterPosition()).getName());
                age.setText(itemList.get(holder.getAdapterPosition()).getAge());
                note.setText(itemList.get(holder.getAdapterPosition()).getNote());

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String e="", n="", a="", no="" ;

                        if (!email.getText().toString().equals("")){
                            e=email.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "Enter Email",Toast.LENGTH_SHORT).show();
                        }

                        if (!name.getText().toString().equals("")){
                            n=name.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "Enter Name",Toast.LENGTH_SHORT).show();
                        }

                        if (!age.getText().toString().equals("")){
                            a=age.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "Enter Age",Toast.LENGTH_SHORT).show();
                        }

                        if (!note.getText().toString().equals("")){
                            no=note.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "Enter Note",Toast.LENGTH_SHORT).show();
                        }


                        itemList.set(position, new Model(e,n,a,no));
                        notifyItemChanged(holder.getAdapterPosition());

                       dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView email;
        TextView name;
        TextView age;
        TextView note;

        private  MainAdapter adapter;

        Button delete,update;

        CardView cardView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            email=itemView.findViewById(R.id.txtemail);
            name=itemView.findViewById(R.id.txtname);
            age=itemView.findViewById(R.id.txtage);
            note=itemView.findViewById(R.id.txtnote);

            update=itemView.findViewById(R.id.btn_update);

            itemView.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.itemList.remove(getAdapterPosition());
                    adapter.notifyItemRemoved(getAdapterPosition());

                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent= new Intent(v.getContext(),Details.class);
                    intent.putExtra("email",itemList.get(getAdapterPosition()).getEmail());
                    intent.putExtra("name", itemList.get(getAdapterPosition()).getName());
                    intent.putExtra("age",itemList.get(getAdapterPosition()).getAge());
                    intent.putExtra("note",itemList.get(getAdapterPosition()).getNote());
                    v.getContext().startActivity(intent);
                }
            });

        }

        public Holder linkAdapter(MainAdapter adapter){
            this.adapter=adapter;
            return this;
        }


    }
}
