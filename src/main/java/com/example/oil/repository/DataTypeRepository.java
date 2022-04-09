package com.example.oil.repository;

import com.example.oil.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface DataTypeRepository extends JpaRepository<DataType, Integer> {

    DataType findByName(String name);
}