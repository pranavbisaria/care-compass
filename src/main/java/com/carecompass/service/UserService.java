package com.carecompass.service;
import com.carecompass.models.User;
import com.carecompass.payloads.OtpDto;
import com.carecompass.payloads.TwilioCacheDto;
import com.carecompass.payloads.UserProfile;
import org.springframework.http.ResponseEntity;
public interface UserService {
    ResponseEntity<?> updateUserProfile(User user, UserProfile userProfile);

    ResponseEntity<?> sendPhoneOTP(User user, TwilioCacheDto twilioCacheDto);

    ResponseEntity<?> verifyResetPhoneOTP(User user, TwilioCacheDto twilioCacheDto);

    ResponseEntity<?> sendEmailOTP(User user, String email) throws Exception;

    ResponseEntity<?> verifyResetEmailOTP(User user, OtpDto otpDto);
}
