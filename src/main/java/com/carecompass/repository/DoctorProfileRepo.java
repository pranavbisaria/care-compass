package com.carecompass.repository;

import com.carecompass.models.DoctorProfile;
import com.carecompass.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorProfileRepo extends JpaRepository<DoctorProfile, Long> {
    DoctorProfile findByUser(User user);
}
