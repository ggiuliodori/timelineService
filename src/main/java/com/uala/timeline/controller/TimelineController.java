package com.uala.timeline.controller;

import com.uala.timeline.client.TweetServiceClient;
import com.uala.timeline.client.UserServiceClient;
import com.uala.timeline.model.api.TweetModel;
import com.uala.timeline.service.TimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timeline-service")
public class TimelineController {
    private final TimelineService timelineService;


    private TimelineController(UserServiceClient userServiceClient, TimelineService timelineService, TweetServiceClient tweetServiceClient) {
        this.timelineService = timelineService;
    }

    @GetMapping("/users/{id}")
    public List<TweetModel> getTimeline(@PathVariable String id) {
        return timelineService.getUsersFollowsAndTweets(id);
    }


}
