package com.uala.timeline.client;

import com.uala.timeline.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserServiceClient {

    private final UserClient userClient;

    public UserServiceClient(UserClient userClient) {
        this.userClient = userClient;
    }

    public List<String> getFollowingUsers(String id) {
        Call<UserModel> call = userClient.getData(id);
        try {
            Response<UserModel> response = call.execute();
            if (response.isSuccessful()) {
                return response.body().getFollowing();
            } else {
                log.error("Get Following error: {}", response.errorBody());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
