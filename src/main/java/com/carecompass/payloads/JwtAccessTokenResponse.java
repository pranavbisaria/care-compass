package com.carecompass.payloads;
import com.carecompass.models.Role;
import java.util.Set;

public record JwtAccessTokenResponse (
    String accessToken,
    String firstname,
    String lastname,
    String Email,
    Set<Role> roles
){}
