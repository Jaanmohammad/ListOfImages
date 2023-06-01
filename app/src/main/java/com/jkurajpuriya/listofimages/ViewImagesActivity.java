package com.jkurajpuriya.listofimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.jkurajpuriya.listofimages.databinding.ActivityViewImagesBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewImagesActivity extends AppCompatActivity {
    ActivityViewImagesBinding binding;
    List<ViewModel> modelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewImagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<List<ViewModel>>() {
            @Override
            public void onResponse(Call<List<ViewModel>> call, Response<List<ViewModel>> response) {
                modelList=response.body();
                binding.recyclerView.setAdapter(new MyAdapter(modelList,ViewImagesActivity.this));
            }

            @Override
            public void onFailure(Call<List<ViewModel>> call, Throwable t) {
                Toast.makeText(ViewImagesActivity.this, "Something Went Wrong....", Toast.LENGTH_SHORT).show();
            }
        });

    }
}