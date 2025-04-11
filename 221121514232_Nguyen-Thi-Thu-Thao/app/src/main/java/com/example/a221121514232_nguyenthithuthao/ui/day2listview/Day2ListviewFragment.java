package com.example.a221121514232_nguyenthithuthao.ui.day2listview;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a221121514232_nguyenthithuthao.R;
import com.example.a221121514232_nguyenthithuthao.adapter.ContactAdapter_1;
import com.example.a221121514232_nguyenthithuthao.model.ContactModel_1;

import java.util.ArrayList;
import java.util.List;

public class Day2ListviewFragment extends Fragment {

    private Day2ListviewViewModel mViewModel;
    private ListView lvContact;
    private List<ContactModel_1> listContacts = new ArrayList<>();


    public static Day2ListviewFragment newInstance() {
        return new Day2ListviewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day2_listview, container, false);

        // Gọi đúng hàm init
        initData();

        // Ánh xạ ListView từ layout
        lvContact = view.findViewById(R.id.lvContact);

        // Truyền getActivity() thay vì Fragment cho adapter
        ContactAdapter_1 adapter = new ContactAdapter_1(getActivity(), listContacts);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemView, int position, long id) {
                ContactModel_1 contactModel1 = listContacts.get(position);
                Toast.makeText(getActivity(), contactModel1.getName1(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
    private void initData(){
        listContacts.add(new ContactModel_1("Nguyễn Thị Bích Ngọc", "0777030723", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Trần Thị Bích Ngọc", "0901234567", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Lê Minh Tú", "0912345678", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Phạm Hữu Sơn", "0933456789", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Nguyễn Thị Lan Anh", "0945123456", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Bùi Thanh Hương", "0967267103", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Vũ Quang Duy", "0987654321", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Đoàn Hải Minh", "0908765432", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Trương Thị Quỳnh Anh", "0982876543", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Hoàng Phúc Hùng", "0376543210", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Lê Đức Tâm", "0862888999", R.drawable.nguyen_thi_thu_thao));
        listContacts.add(new ContactModel_1("Trần Thị Mai", "0948675309", R.drawable.nguyen_thi_thu_thao));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Day2ListviewViewModel.class);
        // TODO: Use the ViewModel
    }

}