package com.example.myapplication;

import static com.example.myapplication.R.id.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapters.AlbumAdapter;
import com.example.myapplication.adapters.PostAdapter;
import com.example.myapplication.adapters.TodoAdapter;
import com.example.myapplication.model.Albuns;
import com.example.myapplication.model.Posts;
import com.example.myapplication.model.Todo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class principalActivity extends AppCompatActivity implements
        Response.ErrorListener {

    private List<Todo> todos = new ArrayList<>();
    private List<Posts> posts = new ArrayList<>();
    private List<Albuns> albums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        Button btn = findViewById(button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                buscarJsons();

            }

        });

    }


    public void buscarJsons() {

        //Aqui inicia o uso do Volley
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponseTodo(response);
                    }
                }, this);
        queue.add(requisicao);

        requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponsePosts(response);
                    }
                }, this);
        queue.add(requisicao);

        requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/albums", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponseAlbums(response);
                    }
                }, this);
        queue.add(requisicao);

    }


    public void onResponseTodo(JSONArray response) {
      //  ScrollView sv = findViewById(scroll);
      //  LinearLayout ll = findViewById(leiauteVertical);

        todos.clear();

        try {
            for (int i = 0 ; i< response.length(); i ++){
                todos.add(new Todo(response.getJSONObject(i)));
            }
            RecyclerView rv = findViewById(rvTodos);
            TodoAdapter adapter = new TodoAdapter(todos);
            LinearLayoutManager llm = new LinearLayoutManager(this);
           // LinearLayoutManager llm1 = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setAdapter(adapter);

         /*   String txt = "";
            for (Todo td : todos){
                Button btn = new Button(this);
                btn.setText("ID"+td.getId());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), DetalheTodoActivity.class);
                        intent.putExtra("obj", td);
                        startActivity(intent);
                    }
                });
                ll.addView(btn);
            }
        */
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void onResponsePosts(JSONArray response) {
        //  ScrollView sv = findViewById(scroll);
        //  LinearLayout ll = findViewById(leiauteVertical);

        todos.clear();

        try {
            for (int i = 0 ; i< response.length(); i ++){
                posts.add(new Posts(response.getJSONObject(i)));
            }
            RecyclerView rv = findViewById(rvTodos);
            PostAdapter adapter = new PostAdapter(posts);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            // LinearLayoutManager llm1 = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setAdapter(adapter);

         /*   String txt = "";
            for (Todo td : todos){
                Button btn = new Button(this);
                btn.setText("ID"+td.getId());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), DetalheTodoActivity.class);
                        intent.putExtra("obj", td);
                        startActivity(intent);
                    }
                });
                ll.addView(btn);
            }
        */
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onResponseAlbums(JSONArray response) {
        //  ScrollView sv = findViewById(scroll);
        //  LinearLayout ll = findViewById(leiauteVertical);

        todos.clear();

        try {
            for (int i = 0 ; i< response.length(); i ++){
                albums.add(new Albuns(response.getJSONObject(i)));
            }
            RecyclerView rv = findViewById(rvTodos);
            AlbumAdapter adapter = new AlbumAdapter(albums);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            // LinearLayoutManager llm1 = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setAdapter(adapter);

         /*   String txt = "";
            for (Todo td : todos){
                Button btn = new Button(this);
                btn.setText("ID"+td.getId());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), DetalheTodoActivity.class);
                        intent.putExtra("obj", td);
                        startActivity(intent);
                    }
                });
                ll.addView(btn);
            }
        */
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {
       // EditText ed = findViewById(resposta);
       // ed.setText(error.getMessage());
    }
}



