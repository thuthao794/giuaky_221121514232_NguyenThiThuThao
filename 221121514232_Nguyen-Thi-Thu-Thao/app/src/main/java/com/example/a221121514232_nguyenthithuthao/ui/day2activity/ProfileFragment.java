package com.example.a221121514232_nguyenthithuthao.ui.day2activity;

import static android.app.Activity.RESULT_OK;
import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a221121514232_nguyenthithuthao.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename and change types of parameters
    private TextView tvUser;
    private Button btEdit;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize the views
        tvUser = rootView.findViewById(R.id.tvUserName);
        btEdit = rootView.findViewById(R.id.btEdit);

        // Get data from the Bundle
        if (getArguments() != null) {
            String userName = getArguments().getString("USER_NAME");
            tvUser.setText(userName);
        }
        btEdit.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btEdit) {
            onEdit();
        }
    }

    private void onEdit() {
        EditUserFragment editUserFragment = new EditUserFragment();
        Bundle args = new Bundle();
        args.putString("USER_NAME", tvUser.getText().toString());
        editUserFragment.setArguments(args);

        // Lấy NavController
        NavController navController = NavHostFragment.findNavController(this);

        // Kiểm tra xem action có tồn tại không
        if (navController.getCurrentDestination() != null) {
            // Điều hướng đến ProfileFragment bằng NavController
            navController.navigate(R.id.action_profileFragment_to_editUserFragment, args);
        } else {
            Toast.makeText(getContext(), "Navigation destination not found", Toast.LENGTH_SHORT).show();
        }
    }
}