
package com.example.recyclerbin;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    String titles[];
    String dirNames[];
    int posters[];

    public MyAdapter(Context ctx, String[] title, String[] sub_title, int[] postr) {
        this.ctx = ctx;
        this.titles = title;
        this.dirNames = sub_title;
        this.posters= postr;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_design,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t.setText(titles[position]);
        holder.st.setText(dirNames[position]);
        holder.img.setImageResource(posters[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t,st;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.title);
            st=itemView.findViewById(R.id.dirNames);
            img=itemView.findViewById(R.id.posters);

        }
    }
}
