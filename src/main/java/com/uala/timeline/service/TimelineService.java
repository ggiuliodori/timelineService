package com.uala.timeline.service;

import com.mongodb.annotations.Sealed;
import com.uala.timeline.client.TweetServiceClient;
import com.uala.timeline.client.UserServiceClient;
import com.uala.timeline.model.TweetModel;
import com.uala.timeline.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        if (!usersId.isEmpty()) {
            return tweetServiceClient.getTweets(usersId);
        } else {
            log.warn("User with ID: {} does not follow any user", id);
            return new ArrayList<>();
        }
    }

}
