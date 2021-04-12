package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Recylerviewdateadapter extends RecyclerView.Adapter<Recylerviewdateadapter.DataView> {
    Context ctx;
    List<Repo> list;

    public Recylerviewdateadapter(Context ctx, List<Repo> list) {
        this.ctx = ctx;
        this.list = list;

    }

    @NonNull
    @Override
    public Recylerviewdateadapter.DataView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataView(LayoutInflater.from(ctx).inflate(R.layout.mylayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recylerviewdateadapter.DataView holder, int position) {

        String repoList = list.get(position).getDate();
        holder.Date.setText(properDateFormat(repoList));
        //holder.Date.setText(list.get(position).getDate());
        holder.Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, properDateFormat(repoList), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DataView extends RecyclerView.ViewHolder {
        TextView Date;
        public DataView(@NonNull View itemView) {
            super(itemView);

        Date=itemView.findViewById(R.id.tv_date);

        }
    }
    private String properDateFormat(String res_Deaths){
        String inputPattern="yyyy-mm-dd";
        String outputPattern="dd-mm-yyyy";
        SimpleDateFormat inputDate=new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputtDate=new SimpleDateFormat(outputPattern);
        Date d=null;
        String str=null;
        try {
            d=inputDate.parse(res_Deaths);
            str=outputtDate.format(d);

        }catch (ParseException e){
            e.printStackTrace();
        }
        return str;
    }
}
