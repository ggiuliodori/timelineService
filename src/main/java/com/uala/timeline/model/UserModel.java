package com.uala.timeline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String id;
    private String username;
    private String email;
    private String password;
    private List<String> following;

}

