package com.carecompass.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long likes = 0L;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Post post;
    private Date postedOn = new Date(System.currentTimeMillis());
    private Boolean ifLiked;
}
