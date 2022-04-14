package com.example.oil.model;

import javax.persistence.*;
import java.util.Date;

import static com.example.oil.utils.DateUtils.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"date"})})
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private Date date;

    private String ruDate;
    private String enDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRuDate() {
        return ruDate;
    }

    public void setRuDate(String ruDate) {
        this.ruDate = ruDate;
    }

    public String getEnDate() {
        return enDate;
    }

    public void setEnDate(String enDate) {
        this.enDate = enDate;
    }
}
