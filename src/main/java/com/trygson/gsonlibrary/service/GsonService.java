package com.trygson.gsonlibrary.service;

import com.google.gson.Gson;
import com.trygson.gsonlibrary.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GsonService {

    private static final Logger logger = LoggerFactory.getLogger(GsonService.class);
    private final Gson gson = new Gson();

    public String toJson(Employee employee) {
        String json = gson.toJson(employee);
        logger.info("Converted Employee to JSON: {}", json);
        return json;
    }

    public Employee fromJson(String json) {
        Employee employee = gson.fromJson(json, Employee.class);
        logger.info("Converted JSON to Employee: {}", employee);
        return employee;
    }
}
