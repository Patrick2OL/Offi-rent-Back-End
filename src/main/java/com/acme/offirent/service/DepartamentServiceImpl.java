package com.acme.offirent.service;

import com.acme.offirent.domain.model.Departament;
import com.acme.offirent.domain.repository.DepartamentRepository;
import com.acme.offirent.domain.service.DepartamentService;
import com.acme.offirent.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DepartamentServiceImpl implements DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    @Override
    public Departament getDepartamentById(Long departamentId) {
        return departamentRepository.findById(departamentId)

                .orElseThrow(()->new ResourceNotFoundException("Departament","Id",departamentId));
    }

    @Override
    public Page<Departament> getAllDepartamentByCountryId(Long countryId, Pageable pageable) {
        return null;
    }

    @Override
    public Departament createDepartament(Departament departament) {
        return departamentRepository.save(departament);
    }

    @Override
    public ResponseEntity<?> deleteDepartament(Long departamentId) {
        return departamentRepository.findById(departamentId).map(departament -> {
            departamentRepository.delete(departament);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Departament","Id",departamentId));
    }
}
