package com.xxx.hep.description.repository;

import com.xxx.hep.common.repository.*;
import com.xxx.hep.description.pojo.Description;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends CommonRepository<Description, Integer> {
}
