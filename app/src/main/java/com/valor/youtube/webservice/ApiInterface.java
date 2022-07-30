package com.valor.youtube.webservice;


import com.valor.youtube.model.PostsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<List<PostsResponse>>  getPostsListFromJsonplaceholder();




}
