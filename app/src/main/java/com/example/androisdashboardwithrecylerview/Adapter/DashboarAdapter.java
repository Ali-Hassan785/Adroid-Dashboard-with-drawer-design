package com.example.androisdashboardwithrecylerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codemybrainsout.ratingdialog.RatingDialog;
import com.example.androisdashboardwithrecylerview.Models.DashBoardModel;
import com.example.androisdashboardwithrecylerview.R;
import com.example.androisdashboardwithrecylerview.Tools.Tools;


import java.util.ArrayList;
import java.util.List;

public class DashboarAdapter extends RecyclerView.Adapter<DashboarAdapter.ViewHolder> {
    private Context context;
    private List<DashBoardModel> dashBoardModelArrayList = new ArrayList<>();

    public DashboarAdapter(Context context, List<DashBoardModel> dashBoardModelArrayList) {
        this.context = context;
        this.dashBoardModelArrayList = dashBoardModelArrayList;
    }

    @NonNull
    @Override
    public DashboarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_layout, parent, false);
        return new DashboarAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboarAdapter.ViewHolder holder, final int position) {

        holder.textView.setText(dashBoardModelArrayList.get(position).getTitle());
        holder.imageView.setImageResource(dashBoardModelArrayList.get(position).getImage_path());
        Tools.setImageViewDrawableColor(holder.imageView, dashBoardModelArrayList.get(position).getColor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    Toast.makeText(context, "Your new Activity "+position+1, Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(context, HomeActivity.class);
//                    context.startActivity(intent);
                }else if (position==1){
                    Tools.Rateus(context);
                }else if (position==2){
                    Tools.ShareApp(context);

                }else if (position==3){
                    Tools.MoreApp(context);

                }else if (position==4){
//                    exit app

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashBoardModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.title);
        }
    }


}
