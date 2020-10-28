package com.acme.offirent.domain.service;

import com.acme.offirent.domain.model.Office;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfficeService {
    Page<Office> getAllOffices(Pageable pageable);
    Office getOfficeById  (Long officeId);
    Page<Office> getAllOfficesByDistrictId(Long districtId, Pageable pageable);
    Page<Office> getAllOfficesByPriceLessThanEqual (Float price, Pageable pageable);


    Office createOffice(Office office);
    Office updateOffice(Long officeId,Office officeRequest);
    ResponseEntity<?> deleteOffice(Long officeId);

}
