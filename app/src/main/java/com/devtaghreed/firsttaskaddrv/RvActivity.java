package com.devtaghreed.firsttaskaddrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.devtaghreed.firsttaskaddrv.databinding.ActivityRvBinding;

import java.util.ArrayList;

public class RvActivity extends AppCompatActivity {
    ActivityRvBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Users");
        ArrayList<UserInfo>user_Infos = (ArrayList<UserInfo>) getIntent().getSerializableExtra("user_Info");

            UserAdapter adapter = new UserAdapter(user_Infos);
            binding.UserRv.setAdapter(adapter);
            binding.UserRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }
}