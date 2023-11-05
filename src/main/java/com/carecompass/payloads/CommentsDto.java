package com.carecompass.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentsDto {
    private Long Id;
    private Long likes = 0L;
    private String description;
    private String postedOn;
    private UserShow user;
    private Boolean ifLiked;
}
