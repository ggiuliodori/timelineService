package com.uala.timeline.client;

import com.uala.timeline.model.api.UserModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserClient {
    @GET("/user-service/users/{id}")
    Call<UserModel> getData(@Path("id") String id);
}

