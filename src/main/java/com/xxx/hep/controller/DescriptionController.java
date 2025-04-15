package com.xxx.hep.controller;

import com.xxx.hep.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/description/")
public class DescriptionController  {
    @Autowired
    private DescriptionService descriptionService;
}
