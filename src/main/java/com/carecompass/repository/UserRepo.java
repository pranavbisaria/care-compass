package com.carecompass.repository;
import com.carecompass.models.PatientProfile;
import com.carecompass.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
    Boolean existsUserByPhoneNumber(String phoneNumber);
    User findByProfile(PatientProfile profile);
}
