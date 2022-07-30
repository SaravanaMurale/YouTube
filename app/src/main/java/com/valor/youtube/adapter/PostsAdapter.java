package com.valor.youtube.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.valor.youtube.R;
import com.valor.youtube.model.PostsResponse;
import com.valor.youtube.utils.AppConstant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    Context context;
    List<PostsResponse> postsResponseList;


     public PostsAdapter(Context context, List<PostsResponse> postsResponseList) {

         this.context=context;
         this.postsResponseList=postsResponseList;

     }

     @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_posts_adapter, parent, false);
         return new PostsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {



        holder.tvTitle.setText(postsResponseList.get(position).getTitle());

        Picasso.with(context).load(AppConstant.IMAGE_URL).into(holder.ivImage);


    }

    @Override
    public int getItemCount() {
        return postsResponseList==null?0:postsResponseList.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ivThumbnail)
        ImageView ivImage;
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
