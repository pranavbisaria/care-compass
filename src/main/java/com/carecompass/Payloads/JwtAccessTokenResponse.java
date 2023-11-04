package com.carecompass.Payloads;
import com.healthive.Models.Role;
import java.util.Set;

public record JwtAccessTokenResponse (
    String accessToken,
    String firstname,
    String lastname,
    String Email,
    Set<Role> roles
){}
