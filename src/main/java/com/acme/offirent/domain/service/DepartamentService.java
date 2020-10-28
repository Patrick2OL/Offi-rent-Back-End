package com.acme.offirent.domain.service;

import com.acme.offirent.domain.model.Departament;
import com.acme.offirent.domain.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartamentService {
    Departament getDepartamentById(Long departamentId);
    Page<Departament> getAllDepartamentByCountryId(Long countryId, Pageable pageable);

    Departament createDepartament(Departament departament);
    ResponseEntity<?> deleteDepartament(Long departamentId);
}
