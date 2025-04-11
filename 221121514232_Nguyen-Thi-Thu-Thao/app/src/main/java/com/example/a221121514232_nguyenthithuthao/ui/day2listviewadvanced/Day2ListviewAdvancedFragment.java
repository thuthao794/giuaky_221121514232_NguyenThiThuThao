package com.example.a221121514232_nguyenthithuthao.ui.day2listviewadvanced;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a221121514232_nguyenthithuthao.R;
import com.example.a221121514232_nguyenthithuthao.adapter.ContactAdapter;
import com.example.a221121514232_nguyenthithuthao.model.ContactModel;
import com.example.a221121514232_nguyenthithuthao.model.ContactModel_1;
import com.example.a221121514232_nguyenthithuthao.network.IOnChildItemClick;

import java.util.ArrayList;
import java.util.List;

public class Day2ListviewAdvancedFragment extends Fragment implements IOnChildItemClick {

    private Day2ListviewAdvancedViewModel mViewModel;
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private TextView tvName;
    private ImageView ivUser;

    public static Day2ListviewAdvancedFragment newInstance() {
        return new Day2ListviewAdvancedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day2_listview_advanced, container, false);

        initView(view); // Truyền view vào
        initData();

        mAdapter = new ContactAdapter(getContext(), listContact);
        mAdapter.registerChildItemClick(new IOnChildItemClick() {
            @Override
            public void onItemChildClick(int position) {
                ContactModel model = listContact.get(position);
                tvName.setText(model.getName());
                ivUser.setImageResource(model.getImage());
            }
        });

        lvContact.setAdapter(mAdapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel model = listContact.get(position);
                Toast.makeText(getContext(), model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void initView (View view) {
        lvContact = view.findViewById(R.id.lvContact);
        tvName = view.findViewById(R.id.tvName);
        ivUser = view.findViewById(R.id.ivUser);
    }

    private void initData() {
        listContact.add(new ContactModel("Nguyễn Thị Thu Thảo", "0777030725", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Trần Thị Minh Châu", "0901234567", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Lê Quang Huy", "0912345678", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Phạm Minh Tuấn", "0933456789", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Vũ Thị Lan", "0987654321", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Đoàn Anh Khoa", "0876543210", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Bùi Hoàng Nam", "0908765432", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Nguyễn Thị Thanh Hoa", "0945123456", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Hoàng Hải Nam", "0962876543", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Lê Văn Tú", "0982789456", R.drawable.nguyen_thi_thu_thao));
        listContact.add(new ContactModel("Trương Thị Quỳnh Anh", "0398456123", R.drawable.nguyen_thi_thu_thao));


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel model = listContact.get(position);
        tvName.setText(model.getName());
        ivUser.setImageResource(model.getImage());

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Day2ListviewAdvancedViewModel.class);
        // TODO: Use the ViewModel
    }

}