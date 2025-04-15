package com.xxx.hep.description.service;

import com.xxx.hep.common.service.*;
import com.xxx.hep.description.pojo.Description;
import com.xxx.hep.description.vo.DescriptionVo;
import com.xxx.hep.description.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class DescriptionServiceImpl extends CommonServiceImpl<DescriptionVo, Description, Integer> implements DescriptionService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private DescriptionRepository descriptionRepository;
}
