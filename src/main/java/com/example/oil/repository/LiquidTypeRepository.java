package com.example.oil.repository;

import com.example.oil.model.LiquidType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface LiquidTypeRepository extends JpaRepository<LiquidType, Integer> {

    LiquidType findByName(String name);
}