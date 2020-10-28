package com.acme.offirent.domain.service;

import com.acme.offirent.domain.model.District;
import com.acme.offirent.domain.model.Office;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DistrictService {
    District getDistrictById(Long districtId);
    Page<District> getAllDistrictByDepartamentId(Long departamentId, Pageable pageable);

    District createDistrict(District district);
    ResponseEntity<?> deleteDistrict(Long districtId);
}
