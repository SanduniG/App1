package com.techleadintl.android.app1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.email.setText(itemList.get(position).getEmail());
        holder.name.setText(itemList.get(position).getName());
        holder.age.setText(itemList.get(position).getAge());
        holder.note.setText(itemList.get(position).getNote());

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

        public Holder(@NonNull View itemView) {
            super(itemView);

            email=itemView.findViewById(R.id.txtemail);
            name=itemView.findViewById(R.id.txtname);
            age=itemView.findViewById(R.id.txtage);
            note=itemView.findViewById(R.id.txtnote);
        }
    }
}
