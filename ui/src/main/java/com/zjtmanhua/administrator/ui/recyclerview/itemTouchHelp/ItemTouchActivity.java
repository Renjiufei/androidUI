package com.zjtmanhua.administrator.ui.recyclerview.itemTouchHelp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.zjtmanhua.administrator.ui.R;
import com.zjtmanhua.administrator.ui.recyclerview.QQAdapter;
import com.zjtmanhua.administrator.ui.recyclerview.itemTouchHelp.date.DataUtils;
import com.zjtmanhua.administrator.ui.recyclerview.itemTouchHelp.date.QQMessage;

import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 */

public class ItemTouchActivity extends AppCompatActivity implements StartDragListener {

    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actity_item);
        ititView();

    }

    private void ititView() {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<QQMessage> list = DataUtils.init();
        QQAdapter adapter = new QQAdapter(list,this);
        recyclerView.setAdapter(adapter);
        //条目触摸帮助类
        ItemTouchHelper.Callback callback = new MyItemTouchHelperCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);






    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
