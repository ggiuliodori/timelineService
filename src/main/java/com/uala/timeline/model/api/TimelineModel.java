package com.uala.timeline.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimelineModel {
    private Optional<List<TweetModel>> timeline;
}
