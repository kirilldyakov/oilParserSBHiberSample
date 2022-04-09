package com.example.oil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.ui.Model;

@NoRepositoryBean
public interface ModelRepository<T extends Model> extends JpaRepository<Model, Long>
{
}