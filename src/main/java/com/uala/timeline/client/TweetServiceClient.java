package com.uala.timeline.client;

import com.uala.timeline.model.api.TweetModel;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

@Component
public class TweetServiceClient {

    private final TweetClient tweetClient;

    public TweetServiceClient(TweetClient tweetClient) {
        this.tweetClient = tweetClient;
    }

    public List<TweetModel> getTweets(List<String> usersId) {
        Call<List<TweetModel>> call = tweetClient.getData(usersId);
        try {
            Response<List<TweetModel>> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
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
