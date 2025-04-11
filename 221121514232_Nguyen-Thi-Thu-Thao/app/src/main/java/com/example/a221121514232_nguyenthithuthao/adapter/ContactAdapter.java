package com.example.a221121514232_nguyenthithuthao.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.example.a221121514232_nguyenthithuthao.R;
import com.example.a221121514232_nguyenthithuthao.model.ContactModel;
import com.example.a221121514232_nguyenthithuthao.network.IOnChildItemClick;

import java.util.List;
import java.util.Objects;

public class ContactAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContactModel> listContact;
    private IOnChildItemClick iOnChildItemClick;

    public ContactAdapter(Context mContext, List<ContactModel> listContact){
        this.mContext = mContext;
        this.listContact = listContact;
    }

    public void registerChildItemClick(IOnChildItemClick iOnChildItemClick){
        this.iOnChildItemClick = iOnChildItemClick;
    }

    public void unRegisterChildItemClick(){
        this.iOnChildItemClick = null;
    }

    // How many items are in the data set represented by this Adapter.
    @Override
    public int getCount() {
        return listContact.size();
    }

    // Get the data item associated with the specified position in the data set.
    @Override
    public ContactModel  getItem(int position){
        return listContact.get(position);
    }

    // Get the row id associated with the specified position in the list.
    @Override
    public long getItemId(int position){
        return 0;
    }

    // Get a View that displays the data at the specified position in the data set.
    @Override
    public View getView(final int position, View converView, ViewGroup viewGroup){

        View rowView = converView;
        // reuse Views

        if (rowView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_contact, null);
            // configure view holder
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) rowView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) rowView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) rowView.findViewById(R.id.ivAvatar);
            holder.btCall = (ImageView) rowView.findViewById(R.id.btCall);
            holder.btEdit = (ImageView) rowView.findViewById(R.id.btEdit);
            rowView.setTag(holder);

        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.tvName.setText(listContact.get(position).getName());
        holder.tvPhone.setText(listContact.get(position).getPhone());
        holder.ivAvatar.setImageResource(listContact.get(position).getImage());

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(position);
            }
        });

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnChildItemClick.onItemChildClick(position);
            }
        });

        return rowView;
    }

    private void onCall(int position){
        ContactModel contact = listContact.get(position);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact.getPhone()));
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            // TODO: Consider calling
            // ActivityCompat#requestPermissions
            // here to request the missing permissions, and the overriding
            // public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mContext.startActivity(intent);
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        ImageView btCall;
        ImageView btEdit;
    }
}


