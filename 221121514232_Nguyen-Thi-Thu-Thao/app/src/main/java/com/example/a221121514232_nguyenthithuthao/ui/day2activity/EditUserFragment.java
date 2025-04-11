package com.example.a221121514232_nguyenthithuthao.ui.day2activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a221121514232_nguyenthithuthao.R;

public class EditUserFragment extends Fragment implements View.OnClickListener {

    private EditText edUser;
    private Button btDone;

    public EditUserFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EditUserFragment newInstance() {
        return new EditUserFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_user, container, false);

        edUser = rootView.findViewById(R.id.edUser);
        btDone = rootView.findViewById(R.id.btDone);


        // Get data from the Bundle
        if (getArguments() != null) {
            String userName = getArguments().getString("USER_NAME");
            edUser.setText(userName);
        }
        btDone.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btDone) {
            onDone();
        }
    }

    private void onDone() {
        // Send result back to ProfileFragment
        String newUserName = edUser.getText().toString();
        ProfileFragment profileFragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString("USER_NAME", newUserName);
        profileFragment.setArguments(args);

        // Lấy NavController
        NavController navController = NavHostFragment.findNavController(this);

        // Kiểm tra xem action có tồn tại không
        if (navController.getCurrentDestination() != null) {
            // Điều hướng đến ProfileFragment bằng NavController
            navController.navigate(R.id.action_editUserFragment_to_profileFragment, args);
        } else {
            Toast.makeText(getContext(), "Navigation destination not found", Toast.LENGTH_SHORT).show();
        }
    }
}