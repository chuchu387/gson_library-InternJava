package com.trygson.gsonlibrary.controller;

import com.trygson.gsonlibrary.model.Employee;
import com.trygson.gsonlibrary.service.GsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GsonController {

    @Autowired
    private GsonService gsonService;

    @PostMapping("/toJson")
    public String toJson(@RequestBody Employee employee) {
        String jsonResult = null;
        try {
            //convert Employee object to JSON
            jsonResult = gsonService.toJson(employee);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = "Error converting to JSON: " + e.getMessage();
        } finally {
            System.out.println("toJson request processing completed.");
        }
        return jsonResult;
    }

    @PostMapping("/fromJson")
    public Employee fromJson(@RequestBody String json) {
        Employee employee = null;
        try {
            //convert JSON string to Employee object
            employee = gsonService.fromJson(json);
        } catch (Exception e) {
            e.printStackTrace();
            employee = new Employee();
            employee.setName("Error");
        } finally {
            System.out.println("fromJson request processing completed.");
        }
        return employee;
    }
}
