package com.carecompass.payloads;
import com.carecompass.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
    private String accessToken;
    private String refreshToken;
    private String firstname;
    private String lastname;
    private String Email;
    private String userId;
    private Set<Role> roles;
}
