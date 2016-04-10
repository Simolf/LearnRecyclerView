package com.example.cxx.learnrecyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取RecyclerView对象
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
        //创建线性布局管理器（默认垂直布局）
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //为RecyclerView指定布局管理对象
        recyclerView.setLayoutManager(layoutManager);
        //创建Adapter
        MyAdapter myAdapter= new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        //设置自定义点击事件
        myAdapter.setOnItemCliclListener(new MyAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
