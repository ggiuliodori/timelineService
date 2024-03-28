package com.uala.timeline.client;

import com.uala.timeline.model.api.TweetModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface TweetClient {
    @POST("/tweets/latest")
    Call<List<TweetModel>> getData(@Body List<String> usersId);
}

