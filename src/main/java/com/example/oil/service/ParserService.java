package com.example.oil.service;

import com.example.oil.model.Company;
import com.example.oil.model.Data;
import com.example.oil.model.DataType;
import com.example.oil.model.LiquidType;
import com.example.oil.repository.CompanyRepository;
import com.example.oil.repository.DataRepository;
import com.example.oil.repository.DataTypeRepository;
import com.example.oil.repository.LiquidTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.oil.utils.DateUtils.getRandomDate;

@Service
public class ParserService {

    @Autowired
    DataRepository dataRepository;
    @Autowired
    DataTypeRepository dataTypeRepository;
    @Autowired
    LiquidTypeRepository liquidTypeRepository;
    @Autowired
    CompanyRepository companyRepository;

    public void start() {

        Company company = getCompany("company");
        DataType dataType = getDataType("forecast");
        LiquidType liquidType = getLiquidTypeByName("oil");


        Data data = new Data(company, getRandomDate(), dataType, liquidType, 15);

        dataRepository.save(data);
    }

    private Company getCompany(String name) {
        Company company = companyRepository.findByName(name);

        if (company==null){
            Company tmp = new Company();
            tmp.setName(name);
            companyRepository.save(tmp);
            company = companyRepository.findByName(name);
        }
        return company;
    }


    private DataType getDataType(String name) {
        DataType dataType = dataTypeRepository.findByName(name);

        if (dataType==null){
            DataType tmp = new DataType();
            tmp.setName(name);
            dataTypeRepository.save(tmp);
            dataType = dataTypeRepository.findByName(name);
        }
        return dataType;
    }

    private LiquidType getLiquidTypeByName(String name) {
        LiquidType liquidType = liquidTypeRepository.findByName(name);

        if (liquidType==null){
            LiquidType tmp = new LiquidType();
            tmp.setName(name);
            liquidTypeRepository.save(tmp);
            liquidType = liquidTypeRepository.findByName(name);
        }
        return liquidType;
    }

}
