package com.devtaghreed.firsttaskaddrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.devtaghreed.firsttaskaddrv.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int num = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Inputs Fields");

        ArrayList<UserInfo> user_Info = new ArrayList<>();
        binding.AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UserFName = binding.FirstNameEt.getText().toString().trim();
                String UserLName = binding.LastNameEt.getText().toString().trim();
                String UserAge = binding.AgeEt.getText().toString().trim();

                if (UserFName.isEmpty()) {
                    binding.FirstNameEt.setError("Please Enter Your First Name");
                }else if (UserLName.isEmpty()) {
                    binding.LastNameEt.setError("Please Enter Your Last Name");
                }else if (UserAge.isEmpty()) {
                    binding.AgeEt.setError("Please Enter Your Age");
                }else if (UserAge.equals(" ")) {
                    binding.AgeEt.setError("Please Enter Your Age");
                }else if (!(UserFName.isEmpty() || UserLName.isEmpty() || UserAge.isEmpty())) {
                    user_Info.add(new UserInfo((UserFName + " " + UserLName), Integer.parseInt(UserAge)));
                    binding.FirstNameEt.setText(" ");
                    binding.LastNameEt.setText(" ");
                    binding.AgeEt.setText(" ");
                    num--;
                    binding.AddBtn.setText(String.valueOf("Add ("+num+")"));
                    if (user_Info.size() >=3){
                        Intent intent = new Intent(MainActivity.this, RvActivity.class);
                        intent.putExtra("user_Info", user_Info);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getBaseContext(), "Enter more than "+num+" data", Toast.LENGTH_SHORT).show();

                    }
                }
        }
        });
    }
}