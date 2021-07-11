package com.udaan.sample.controllers;

import java.util.List;

import com.udaan.sample.data.entities.Test;
import com.udaan.sample.data.repositories.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/test")
public class TestController {
    
    @Autowired
    private TestRepository testRepository;

    @GetMapping(path = "/get")
    public @ResponseBody List<Test> getData() {
        return (List<Test>) testRepository.findAll();
    }

    @PostMapping(path = "/post")
	public @ResponseBody Test postData(@RequestParam String value) {

        Test test = new Test();
        test.setValue(value);

        test = testRepository.save(test);
		return test;
	}
}
