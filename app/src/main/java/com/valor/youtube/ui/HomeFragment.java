package com.valor.youtube.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.valor.youtube.MainActivity;
import com.valor.youtube.R;
import com.valor.youtube.adapter.PostsAdapter;
import com.valor.youtube.model.PostsResponse;
import com.valor.youtube.utils.Utils;
import com.valor.youtube.webservice.ApiClient;
import com.valor.youtube.webservice.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.rvPosts)
    RecyclerView rvPosts;
    PostsAdapter postsAdapter;

    @BindView(R.id.locateProgressBar)
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_fragment_home, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvPosts.setLayoutManager(linearLayoutManager);
        rvPosts.setHasFixedSize(true);


        getPostsList();

        return rootView;
    }

    private void getPostsList() {

        if (Utils.isNetworkAvailable(getContext())){
            progressBar.setVisibility(View.VISIBLE);
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<PostsResponse>> call =apiService.getPostsListFromJsonplaceholder();
            call.enqueue(new Callback<List<PostsResponse>>() {
                @Override
                public void onResponse(Call<List<PostsResponse>> call, Response<List<PostsResponse>> response) {

                    List<PostsResponse> postsResponseList=response.body();

                    postsAdapter=new PostsAdapter(getContext(),postsResponseList );
                    rvPosts.setAdapter(postsAdapter);

                    progressBar.setVisibility(View.INVISIBLE);


                }

                @Override
                public void onFailure(Call<List<PostsResponse>> call, Throwable t) {
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });



        }else {
            Utils.showToast(getContext(),"Please Check Your Internet");
        }


    }
}
