package com.carecompass.controllers;
import com.carecompass.models.Images;
import com.carecompass.models.User;
import com.carecompass.payloads.ApiResponse;
import com.carecompass.payloads.HealthRecordDto;
import com.carecompass.security.CurrentUser;
import com.carecompass.service.HealthRecordService;
import com.carecompass.service.StorageServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Objects;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path ="/api/healthRecord")
@RequiredArgsConstructor
public class HealthRecordController {
    private final HealthRecordService healthRecordService;
    private final StorageServices storageServices;
    @PostMapping("/saveRecord")
    public ResponseEntity<?> saveRecord(@CurrentUser User user, @RequestPart("images") MultipartFile[] images, @Valid @RequestPart HealthRecordDto healthRecordDto) throws Exception {
        if (FileValidation(images))
            return new ResponseEntity<>(new ApiResponse("File is not of image type(JPEG/ JPG or PNG)!!!", false), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        Arrays.stream(images).forEach(multipartFile -> {
            String image = this.storageServices.uploadFile(multipartFile);
            healthRecordDto.getUploadFiles().add(new Images(image));
        });
        this.healthRecordService.addPatientRecord(null, user, healthRecordDto.getName(), healthRecordDto.getLocation(), healthRecordDto.getTo(), healthRecordDto.getFrom(), healthRecordDto.getSymptoms(), healthRecordDto.getUploadFiles(), healthRecordDto.getDescription());
        return new ResponseEntity<>(new ApiResponse("Your health Record Successfully added to the queue", true), OK);
    }
    @GetMapping("/getRecord")
    public ResponseEntity<?> getHealthRecord(@CurrentUser User user) throws Exception {
        return new ResponseEntity<>(this.healthRecordService.getPatientRecord(user), OK);
    }
    @PutMapping("/updateRecord/{id}")
    public ResponseEntity<?> updateHealthRecord(@CurrentUser User user, @PathVariable("id") Long id, @RequestPart("images") MultipartFile[] images, @Valid @RequestPart HealthRecordDto healthRecordDto) throws Exception {
        if (FileValidation(images))
            return new ResponseEntity<>(new ApiResponse("File is not of image type(JPEG/ JPG or PNG)!!!", false), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        Arrays.stream(images).forEach(multipartFile -> {
            String image = this.storageServices.uploadFile(multipartFile);
            healthRecordDto.getUploadFiles().add(new Images(image));
        });
        this.healthRecordService.addPatientRecord(id, user, healthRecordDto.getName(), healthRecordDto.getLocation(), healthRecordDto.getTo(), healthRecordDto.getFrom(), healthRecordDto.getSymptoms(), healthRecordDto.getUploadFiles(), healthRecordDto.getDescription());
        return new ResponseEntity<>(new ApiResponse("Your update request health Record Id:"+id+" has been successfully added to the queue", true), OK);
    }
    public boolean FileValidation(MultipartFile[] images) throws NullPointerException{
        for (MultipartFile image : images) {
            if (!Objects.equals(image.getContentType(), "image/png") && !Objects.equals(image.getContentType(), "image/jpg") && !Objects.equals(image.getContentType(), "image/jpeg") && !Objects.equals(image.getContentType(), "image/webp")) {
                return true;
            }
        }
        return false;
    }
}
