package com.zjtmanhua.administrator.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zjtmanhua.administrator.ui.recyclerview.DividerItemDecoration;
import com.zjtmanhua.administrator.ui.recyclerview.MyRecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recylerview;
    private ArrayList<String> list;
    private MyRecyclerAdapter adapter;
//private MyStaggedRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<String>();
        for (int i = 0; i < 60; i++) {
            list.add("item" + i);
        }
        recylerview = (RecyclerView) findViewById(R.id.recylerview);
        adapter = new MyRecyclerAdapter(list);
//        adapter = new MyStaggedRecyclerAdapter(list);
        //比listview 使用要多设置一个LinearLayoutManager （源码）
//        recylerview.setLayoutManager(new LinearLayoutManager(this));//默认垂直
        //横向 true 最右边是第一个条目
        recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        recylerview.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL));
        recylerview.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "点我干嘛" + position, Toast.LENGTH_SHORT).show();


            }
        });
        recylerview.setAdapter(adapter);
        recylerview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));


    }


    //添加条目动画


}

