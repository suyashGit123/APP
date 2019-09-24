package com.example.auth;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


   public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
    {
        Context context;
        ArrayList<Profile> profiles;

        public MyAdapter(Context c , ArrayList<Profile> p)
        {
            context = c;
            profiles = p;
        }

        @NonNull
        @Override

        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
        }


        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.name.setText(profiles.get(position).getName());
            holder.email.setText(profiles.get(position).getEmail());
            Picasso.get().load(profiles.get(position).getProfilePic()).into(holder.profilePic);
            if(profiles.get(position).getPermission()) {
                holder.btn.setVisibility(View.VISIBLE);
                holder.onClick(position);
            }



        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class MyViewHolder extends RecyclerView.ViewHolder
         {
             ImageView profilePic;
             Button btn;
             TextView name,email;
             public MyViewHolder(@NonNull View itemView) {
                 super(itemView);
                 name = (TextView)itemView.findViewById(R.id.name);
                 email = (TextView)itemView.findViewById(R.id.email);
                 profilePic = (ImageView) itemView.findViewById(R.id.profilePic);
                 btn = (Button) itemView.findViewById(R.id.CheckDetails);
             }
             public void onClick(final int position)
             {
                 btn.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();
                     }
                 });
         }

         }}


