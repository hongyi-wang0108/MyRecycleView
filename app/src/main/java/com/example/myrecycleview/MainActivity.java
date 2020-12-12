package com.example.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_main;
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter fruitAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main = findViewById(R.id.rv_main);
        init();
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        fruitAdapter = new FruitAdapter(fruitList);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
       // rv_main.setLayoutManager(manager);
        //rv_main.setLayoutManager(new GridLayoutManager(MainActivity.this,6));//5列
        //rv_main.setLayoutManager(new StaggeredGridLayoutManager(7,LinearLayoutManager.HORIZONTAL));//7hang
        rv_main.setLayoutManager(new StaggeredGridLayoutManager(7,LinearLayoutManager.VERTICAL));//7lie

        rv_main.setAdapter(fruitAdapter);

    }

    private void init() {
        for (int i = 0; i < 20; i++) {
            Fruit f = new Fruit(R.drawable.a,"apple");
            fruitList.add(f);
            Log.d("TAG", f.toString());
            Log.d("TAG", fruitList.size()+"");
        }
    }
}