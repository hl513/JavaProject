package com.xxx.hep.service.impl;

import com.xxx.hep.dao.DescriptionRepository;
import com.xxx.hep.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class DescriptionServiceImpl implements DescriptionService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private DescriptionRepository descriptionRepository;
}
