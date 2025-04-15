package com.xxx.hep.description.controller;

import com.xxx.hep.common.controller.*;
import com.xxx.hep.description.pojo.Description;
import com.xxx.hep.description.vo.DescriptionVo;
import com.xxx.hep.description.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/description/")
public class DescriptionController extends CommonController<DescriptionVo, Description, Integer> {
    @Autowired
    private DescriptionService descriptionService;
}
