package com.carecompass.Repository;
import com.carecompass.models.PatientProfile;
import com.carecompass.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientProfileRepo extends JpaRepository<PatientProfile, Long> {
    PatientProfile findByUser(User user);
}
