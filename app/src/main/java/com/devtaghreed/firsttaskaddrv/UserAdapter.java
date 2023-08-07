package com.devtaghreed.firsttaskaddrv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devtaghreed.firsttaskaddrv.databinding.ItemRvBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    ArrayList<UserInfo>user_Info;

    public UserAdapter(ArrayList<UserInfo> userInfo) {
        this.user_Info = userInfo;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRvBinding binding = ItemRvBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserInfo userInfo = user_Info.get(position);
        holder.UserName.setText(userInfo.FirstName);
        holder.UserName.setText(userInfo.FirstName);
        holder.UserAge.setText(String.valueOf(userInfo.Age));
    }

    @Override
    public int getItemCount() {
        return user_Info.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView UserImg;
        TextView UserName;
        TextView UserAge;
        public UserViewHolder(@NonNull ItemRvBinding binding) {
            super(binding.getRoot());
            UserImg = binding.UserImg;
            UserName = binding.NameTv;
            UserAge = binding.AgeTv;

        }
    }
}
