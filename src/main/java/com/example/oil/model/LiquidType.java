package com.example.oil.model;

import javax.persistence.*;

@Entity
@Cacheable
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class LiquidType {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
 
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}