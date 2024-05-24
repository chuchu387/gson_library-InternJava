package com.trygson.gsonlibrary.controller;

import com.trygson.gsonlibrary.model.Employee;
import com.trygson.gsonlibrary.service.GsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GsonController {

    @Autowired
    private GsonService gsonService;

    @PostMapping("/toJson")
    public String toJson(@RequestBody Employee employee) {
        return gsonService.toJson(employee);
    }

    @PostMapping("/fromJson")
    public Employee fromJson(@RequestBody String json) {
        return gsonService.fromJson(json);
    }
}
