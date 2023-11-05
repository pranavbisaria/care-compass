package com.carecompass.payloads;

import com.carecompass.models.Images;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthRecordDto {
    String name;
    String location;
    String from;
    String to;
    String symptoms;
    List<Images> uploadFiles = new ArrayList<>(0);
    String description;
}
