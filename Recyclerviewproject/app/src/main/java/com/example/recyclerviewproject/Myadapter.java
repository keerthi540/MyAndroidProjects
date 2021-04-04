package com.example.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewadapter> {
    Context ct;
    String[] uname,uroll,umail,uphone;
    public Myadapter(MainActivity mainActivity, String[] names, String[] roll, String[] mail, String[] phone) {
ct=mainActivity;
uname=names;
umail=mail;
uroll=roll;
uphone=phone;
    }

    @NonNull
    @Override
    public Myadapter.Myviewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(ct).inflate(R.layout.adapter,parent,false);
        return new Myviewadapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.Myviewadapter holder, int position) {
holder.tv1.setText(uname[position]);
holder.tv2.setText(uroll[position]);
holder.tv3.setText(umail[position]);
holder.tv4.setText(uphone[position]);
    }

    @Override
    public int getItemCount() {
        return uname.length;
    }

    public class Myviewadapter extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        public Myviewadapter(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.name);
            tv2=itemView.findViewById(R.id.roll);
            tv3=itemView.findViewById(R.id.mail);
            tv4=itemView.findViewById(R.id.phone);

        }
    }
}
