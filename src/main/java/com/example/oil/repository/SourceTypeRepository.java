package com.example.oil.repository;

import com.example.oil.model.SourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceTypeRepository extends JpaRepository<SourceType, Integer> {

    SourceType findByName(String name);
}