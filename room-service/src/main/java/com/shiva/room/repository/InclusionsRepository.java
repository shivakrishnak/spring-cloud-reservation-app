package com.shiva.room.repository;

import com.shiva.room.model.Inclusion;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InclusionsRepository extends JpaRepository<Inclusion, Long> {

    @Cacheable("inclusions")
    List<Inclusion> findAll();
}
