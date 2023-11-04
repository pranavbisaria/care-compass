package com.carecompass.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthRecordDto {
    BigInteger Id;
    String name;
    String location;
    String from;
    String to;
    String symptoms;
    List<String> prescriptionUrls = new ArrayList<>(0);
    String description;
}
