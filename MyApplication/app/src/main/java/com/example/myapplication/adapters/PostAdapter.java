package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Posts;
import com.example.myapplication.model.Todo;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Posts> dados;
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PostAdapter(List<Posts> posts){this.dados = posts; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_layout, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Posts posts = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvtitulo);
        tv.setText(posts.getTitle());
        tv.setText(""+posts.getUser_id());
        tv.setText(""+posts.id());
        Switch sw = holder.view.findViewById(R.id.swTodoCompleto);
        sw.setChecked(posts.isCompleted());
    }

    @Override
    public int getItemCount() { return dados.size(); }


}
