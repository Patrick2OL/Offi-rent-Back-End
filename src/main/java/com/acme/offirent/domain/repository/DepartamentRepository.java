package com.acme.offirent.domain.repository;

import com.acme.offirent.domain.model.Departament;
import com.acme.offirent.domain.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
    //Page<Departament> findByCountryId (Long countryId, Pageable pageable);
}
