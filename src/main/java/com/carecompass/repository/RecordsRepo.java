package com.carecompass.repository;

import com.carecompass.models.Records;
import com.carecompass.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecordsRepo  extends JpaRepository<Records, Long> {
    List<Records> findAllByUser(User user);
}
