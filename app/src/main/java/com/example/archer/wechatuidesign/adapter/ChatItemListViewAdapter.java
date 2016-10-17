package com.example.archer.wechatuidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archer.wechatuidesign.R;
import com.example.archer.wechatuidesign.bean.ChatItemListViewBean;

import java.util.List;

/**
 * Created by Archer on 2016/10/17.
 * <p>
 * 描述:
 * <p>
 * 作者
 */

public class ChatItemListViewAdapter  extends BaseAdapter{
    private List<ChatItemListViewBean> mData;
    private LayoutInflater mInflater;

    public ChatItemListViewAdapter(Context context, List<ChatItemListViewBean> mData) {
        this.mData = mData;
        mInflater = LayoutInflater.from(context);
    }


    public int getCount() {
        return mData.size();
    }


    public Object getItem(int position) {
        return mData.get(position);
    }


    public long getItemId(int position) {
        return position;
    }


    public int getItemViewType(int position) {
        ChatItemListViewBean bean = mData.get(position);
        return bean.getType();
    }

    public int getViewTypeCount() {
        return 2;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            if (getItemViewType(position) == 0) {
                holder=new ViewHolder();
                convertView = mInflater.inflate(R.layout.chat_item_in, null);
                assert false;
                holder.icon = (ImageView) convertView.findViewById(R.id.iv_icon);
                holder.textView = (TextView) convertView.findViewById(R.id.text_in);

            } else {
                holder=new ViewHolder();
                convertView = mInflater.inflate(R.layout.chat_item_out, null);
                assert false;
                holder.icon = (ImageView) convertView.findViewById(R.id.iv_icon1);
                holder.textView = (TextView) convertView.findViewById(R.id.text_in);
                convertView.setTag(holder);
            }
            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageBitmap(mData.get(position).getIcon());
        holder.textView.setText(mData.get(position).getText());
        return  convertView;
    }



    private final   class  ViewHolder{
        ImageView icon;
        TextView textView;
    }

}
