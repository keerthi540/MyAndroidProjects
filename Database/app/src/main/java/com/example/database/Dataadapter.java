package com.example.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Dataadapter extends RecyclerView.Adapter<Dataadapter.DataVIewHolder> {
    Context ct;
    List<Data> list;

    public Dataadapter(MainActivity mainActivity, List<Data> datalist) {
        ct = mainActivity;
        list = datalist;
    }

    @NonNull
    @Override
    public DataVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.database,parent,false);
        return new DataVIewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataVIewHolder holder, int position) {
    Data student=list.get(position);
    holder.name.setText(student.getName());
    holder.email.setText(student.getMailid());
    holder.phone.setText(student.getPhonenumber());
    holder.gender.setText(student.getGrnder());
    holder.language.setText(student.getLanguage());
    holder.department.setText(student.getDepartment());
    holder.rollnumber.setText(student.getRollnumber());
holder.delete.setOnClickListener(new View());{

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DataVIewHolder extends RecyclerView.ViewHolder {

        TextView name,email,phone,rollnumber,gender,language,department;
        ImageView update,delete;
        public DataVIewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            phone=itemView.findViewById(R.id.phn);
            rollnumber=itemView.findViewById(R.id.Roll);
            gender=itemView.findViewById(R.id.gender);
            language=itemView.findViewById(R.id.lan);
            department=itemView.findViewById(R.id.dept);
            update=itemView.findViewById(R.id.update);
            delete=itemView.findViewById(R.id.delete);

        }
    }
}
