package com.uala.timeline.service;

import com.mongodb.annotations.Sealed;
import com.uala.timeline.client.TweetServiceClient;
import com.uala.timeline.client.UserServiceClient;
import com.uala.timeline.model.TweetModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineService {
    private final UserServiceClient userServiceClient;
    private final TweetServiceClient tweetServiceClient;

    public TimelineService(UserServiceClient userServiceClient, TweetServiceClient tweetServiceClient) {
        this.userServiceClient = userServiceClient;
        this.tweetServiceClient = tweetServiceClient;
    }

    public List<TweetModel> getUsersFollowsAndTweets(String id) {
        List<String> usersId = userServiceClient.getFollowingUsers(id);
        return tweetServiceClient.getTweets(usersId);

    }

}
