package com.uala.timeline.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uala.timeline.client.TweetClient;
import com.uala.timeline.client.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.LocalDateTime;

@Configuration
public class RetrofitConfig {

    @Value("${baseUserUrl}")
    private String baseUserUrl;
    @Value("${baseTweetUrl}")
    private String baseTweetUrl;

    @Bean
    public UserClient userService() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUserUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(UserClient.class);
    }

    @Bean
    public TweetClient tweetService() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseTweetUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(TweetClient.class);
    }
}
