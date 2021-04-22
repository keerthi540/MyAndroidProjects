package com.example.firebasedatabaseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmplyoyeeAdapter extends RecyclerView.Adapter<EmplyoyeeAdapter.EmployeeViewHolder> {
    Context ctx;
    List<employee> list;

    public EmplyoyeeAdapter(MainActivity mainActivity, List<employee> list) {
        this.ctx = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public EmplyoyeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeViewHolder(LayoutInflater.from(ctx)
                .inflate(R.layout.design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmplyoyeeAdapter.EmployeeViewHolder holder, int position) {
        employee emp = list.get(position);

        holder.n.setText(emp.ename);
        holder.i.setText(emp.eid);
        holder.s.setText(emp.eSalary);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView n, i, s;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            n = itemView.findViewById(R.id.empNAME);
            i = itemView.findViewById(R.id.empID);
            s = itemView.findViewById(R.id.empsal);
        }
    }
}
