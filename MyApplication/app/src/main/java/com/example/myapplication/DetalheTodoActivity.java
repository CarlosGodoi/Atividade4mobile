package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.model.Todo;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);
        Intent intent = getIntent();
        TextView tv = findViewById(R.id.tvid);
        int i = intent.getIntExtra("id", -1);
        Todo todo = intent.getParcelableExtra("obj");
        tv.setText(""+todo.getId());
        tv = findViewById(R.id.tvtitulo);
        tv.setText(todo.getTitle());
    }
}