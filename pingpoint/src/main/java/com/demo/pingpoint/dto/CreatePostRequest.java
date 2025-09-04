package com.demo.pingpoint.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {
    private String content;
    private int userId;
    private Long endpointId;
}


