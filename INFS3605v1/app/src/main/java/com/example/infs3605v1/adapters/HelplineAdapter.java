package com.example.infs3605v1.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.infs3605v1.R;
import com.example.infs3605v1.database.Helpline;

import java.util.ArrayList;

public class HelplineAdapter extends RecyclerView.Adapter<HelplineAdapter.HelplineElementViewHolder> {

    Context context;
    private ArrayList<Helpline> helplineArrayList;
    Uri uri;
    Intent intent;

    public HelplineElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.helpline_element, parent,
                false);
        HelplineElementViewHolder helplineElementViewHolder = new HelplineElementViewHolder(view);
        return helplineElementViewHolder;
    }

    public void onBindViewHolder(@NonNull HelplineElementViewHolder holder, int position) {
        final Helpline helplineElement = helplineArrayList.get(position);
        context = holder.view.getContext();
        holder.helplineLink.setText(helplineElement.getLink());
        holder.helplinePhone.setText(helplineElement.getPhone());
        holder.helplineDesc.setText(helplineElement.getDesc());
        Glide.with(holder.view.getContext()).load(helplineElement.getLogoLink()).into(holder.helplineImage);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("http://" + helplineElement.getLink());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });

    }

    public int getItemCount() {
        return helplineArrayList.size();
    }

    public void setData(ArrayList<Helpline> data) {
        this.helplineArrayList = data;
    }

    public static class HelplineElementViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView helplineLink;
        public TextView helplinePhone;
        public TextView helplineDesc;
        public ImageView helplineImage;

        public HelplineElementViewHolder(View v) {
            super(v);
            view = v;
            helplineLink = v.findViewById(R.id.helplineLink);
            helplinePhone = v.findViewById(R.id.helplinePhone);
            helplineDesc = v.findViewById(R.id.helplineDesc);
            helplineImage = v.findViewById(R.id.helplineImage);
        }
    }
}
