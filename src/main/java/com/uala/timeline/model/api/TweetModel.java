package com.uala.timeline.model.api;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TweetModel {
    private String id;
    private String userId;
    private String content;
    private LocalDateTime timestamp;
}
