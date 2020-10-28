package com.acme.offirent.service;

import com.acme.offirent.domain.model.District;
import com.acme.offirent.domain.repository.DepartamentRepository;
import com.acme.offirent.domain.repository.DistrictRepository;
import com.acme.offirent.domain.service.DistrictService;
import com.acme.offirent.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DepartamentRepository departamentRepository;

    @Override
    public District getDistrictById(Long districtId) {
        return districtRepository.findById(districtId)

                .orElseThrow(()->new ResourceNotFoundException("District","Id",districtId));
    }


    @Override
    public Page<District> getAllDistrictByDepartamentId(Long departamentId, Pageable pageable) {

        return departamentRepository.findById(departamentId).map( departament -> {
            List<District> districts= departament.getDistricts();
            int districtsCounts = districts.size();
            return new PageImpl<>(districts,pageable,districtsCounts);
        }).orElseThrow(()->new ResourceNotFoundException("Departament","Id",departamentId));
    }

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public ResponseEntity<?> deleteDistrict(Long districtId) {
        return districtRepository.findById(districtId).map(district -> {
            districtRepository.delete(district);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("District","Id",districtId));
    }
}
