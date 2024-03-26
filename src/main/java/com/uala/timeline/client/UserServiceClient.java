package com.uala.timeline.client;

import com.uala.timeline.model.UserModel;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

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
                // Procesar la respuesta según sea necesario
            } else {
                // Manejar el error
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción
        }
        return null;
    }
}
