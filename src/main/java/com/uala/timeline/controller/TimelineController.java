package com.uala.timeline.controller;

import com.uala.timeline.client.TweetServiceClient;
import com.uala.timeline.client.UserServiceClient;
import com.uala.timeline.model.TweetModel;
import com.uala.timeline.service.TimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimelineController {
    private final TimelineService timelineService;


    private TimelineController(UserServiceClient userServiceClient, TimelineService timelineService, TweetServiceClient tweetServiceClient) {
        this.timelineService = timelineService;
    }

    @GetMapping("/api/users/{id}")
    public List<TweetModel> getTimeline(@PathVariable String id) {
        return timelineService.getUsersFollowsAndTweets(id);
    }


}