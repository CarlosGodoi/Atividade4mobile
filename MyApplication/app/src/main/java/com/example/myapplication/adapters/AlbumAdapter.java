package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Albuns;
import com.example.myapplication.model.Posts;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List <Albuns> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


}
    public AlbumAdapter(List<Albuns> albuns){this.dados = albuns;}

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

        Albuns albuns = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvtitulo);
        tv.setText(albuns.getTitle());
        tv.setText(""+albuns.getUser_id());
        tv.setText(""+albuns.id());
        Switch sw = holder.view.findViewById(R.id.swTodoCompleto);
        sw.setChecked(albuns.isCompleted());
    }

    @Override
    public int getItemCount() { return dados.size(); }


}


