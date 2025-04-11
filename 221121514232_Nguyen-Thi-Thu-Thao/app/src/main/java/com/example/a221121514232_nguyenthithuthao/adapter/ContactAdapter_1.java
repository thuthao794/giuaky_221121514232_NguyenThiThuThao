package com.example.a221121514232_nguyenthithuthao.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a221121514232_nguyenthithuthao.R;
import com.example.a221121514232_nguyenthithuthao.model.ContactModel_1;

import java.util.List;

public class ContactAdapter_1  extends BaseAdapter {
    private List<ContactModel_1> listContacts;
    private Activity activity;

    public ContactAdapter_1(Activity activity, List<ContactModel_1> listContacts) {
        this.listContacts = listContacts;
        this.activity = activity;
    }

    @Override
    public int getCount(){
        return listContacts.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_contact_1,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        ContactModel_1 contactModel1 = listContacts.get(position);
        holder.tvName.setText(contactModel1.getName1());
        holder.tvPhone.setText(contactModel1.getPhone1());
        holder.ivAvatar.setImageResource(contactModel1.getImage1());
        return convertView;
    }

    static class ViewHolder{
        ImageView ivAvatar;
        TextView tvName;
        TextView tvPhone;
    }
}

