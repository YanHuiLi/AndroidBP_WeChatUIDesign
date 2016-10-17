package com.example.archer.wechatuidesign.activity;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.archer.wechatuidesign.R;
import com.example.archer.wechatuidesign.adapter.ChatItemListViewAdapter;
import com.example.archer.wechatuidesign.bean.ChatItemListViewBean;

import java.util.ArrayList;
import java.util.List;

import static com.example.archer.wechatuidesign.R.id.send;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private EditText editText;
    private Button btn;
    private ChatItemListViewAdapter mAdapter;
    private List<ChatItemListViewBean> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView) findViewById(R.id.list_view_chat);
        editText= (EditText) findViewById(R.id.et_send);
        btn= (Button) findViewById(send);
        data = new ArrayList<>();
        initMsgs();
        mAdapter=new ChatItemListViewAdapter(this,data);
        mListView.setAdapter(mAdapter);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s = editText.getText().toString();
                 ChatItemListViewBean beanAdd=new ChatItemListViewBean();
                 beanAdd.setText(s);
                 beanAdd.setIcon(BitmapFactory.decodeResource(getResources(),R.drawable.banana_pic));
                 beanAdd.setType(1);
                 data.add(beanAdd);
                 mAdapter.notifyDataSetChanged();//如果数据来就更新adapter;
                 mListView.setSelection(data.size());//定位到最后一行信息记录
                 editText.setText("");//清空edittext的数据
             }
         });

    }

    private  void initMsgs(){
        ChatItemListViewBean bean1=new ChatItemListViewBean();
        bean1.setType(0);
        bean1.setIcon(BitmapFactory.decodeResource(getResources(),R.drawable.apple_pic));
        bean1.setText("Hello how are U ?");
        data.add(bean1);

        ChatItemListViewBean bean2=new ChatItemListViewBean();
        bean2.setType(1);
        bean2.setIcon(BitmapFactory.decodeResource(getResources(),R.drawable.banana_pic));
        bean2.setText("I am fine thank ?");
        data.add(bean2);

    }
}
