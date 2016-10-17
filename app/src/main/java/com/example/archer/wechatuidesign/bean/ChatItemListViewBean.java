package com.example.archer.wechatuidesign.bean;

import android.graphics.Bitmap;

/**
 * Created by Archer on 2016/10/17.
 * <p>
 * 描述:
 * <p>
 * 作者
 */

public class ChatItemListViewBean {

    public ChatItemListViewBean() {
    }

    private  int type;
    private String text;
    private Bitmap icon;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

}
