package com.carecompass.service;

import com.carecompass.models.Images;
import com.carecompass.models.Records;
import com.carecompass.models.User;
import com.carecompass.repository.RecordsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthRecordService {
    private final RecordsRepo recordsRepo;
    @Async
    public void addPatientRecord(Long id, User user, String name, String location, String to, String from, String symptoms, List<Images> prescriptionUrls, String description) {
        if(id!=null) {
            Records records = this.recordsRepo.findById(id).orElse(null);
            if(records !=null) {
                records.setName(name);
                records.setLocation(location);
                records.setFrom(from);
                records.setTo(to);
                records.setSymptoms(symptoms);
                records.setUploadFiles(prescriptionUrls);
                records.setDescription(description);
                this.recordsRepo.save(records);
                return;
            }
        }
        Records records = new Records(name, user, location, from, to, symptoms, prescriptionUrls, description);
        this.recordsRepo.save(records);
    }
    public List<Records> getPatientRecord(User user) {
        return this.recordsRepo.findAllByUser(user);
    }
}
