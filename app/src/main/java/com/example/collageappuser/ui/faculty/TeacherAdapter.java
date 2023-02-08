package com.example.collageappuser.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collageappuser.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter>{

    private List<TeacherData> list;
    private Context context;

    public TeacherAdapter(List<TeacherData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.teacher_faculty_item,parent,false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {
        TeacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.post.setText(item.getPost());
        holder.email.setText(item.getEmail());
        try {
            Picasso.get().load(item.getImage()).into(holder.image);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name,post,email;
        private ImageView image;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            post = itemView.findViewById(R.id.teacherPost);
            email = itemView.findViewById(R.id.teacherEmail);
            image = itemView.findViewById(R.id.teacherImage);
        }
    }
}
