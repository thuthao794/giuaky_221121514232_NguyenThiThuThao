package com.example.a221121514232_nguyenthithuthao.ui.day3networkbasic;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a221121514232_nguyenthithuthao.R;
import com.example.a221121514232_nguyenthithuthao.model.Item;
import com.example.a221121514232_nguyenthithuthao.network.APIManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Day3NetworkBasicFragment extends Fragment {

    private Day3NetworkBasicViewModel mViewModel;
    TextView tvDate, tvTitle, tvContent;
    ImageView ivCover;

    public static Day3NetworkBasicFragment newInstance() {
        return new Day3NetworkBasicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_day3_network_basic, container, false);

        tvDate = root.findViewById(R.id.tvDate);
        tvTitle = root.findViewById(R.id.tvTitle);
        ivCover = root.findViewById(R.id.ivCover);
        tvContent = root.findViewById(R.id.tvContent);

        getData();

        return root;
    }

    private void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getItemData("tt7631058").enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if(response.body() == null){
                    return;
                }
                Item item = response.body();
                tvDate.setText(item.getDate());
                tvTitle.setText(item.getTitle());
                tvContent.setText(item.getContent());
                Glide.with(requireContext()).load(item.getImage()).into(ivCover);

            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.d("MainActivity6", "onFailure: " + t);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Day3NetworkBasicViewModel.class);
        // TODO: Use the ViewModel
    }

}