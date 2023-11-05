package com.carecompass.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private String location;
    private String from;
    private String to;
    private String symptoms;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Images> uploadFiles;
    private String description;

    public Records(String name, User user, String location, String from, String to, String symptoms, List<Images> uploadFiles, String description) {
        this.name = name;
        this.user = user;
        this.location = location;
        this.from = from;
        this.to = to;
        this.symptoms = symptoms;
        this.uploadFiles = uploadFiles;
        this.description = description;
    }
}
