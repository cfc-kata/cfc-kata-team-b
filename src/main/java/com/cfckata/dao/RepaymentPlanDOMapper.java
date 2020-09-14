package com.cfckata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RepaymentPlanDOMapper {
    int update(RepaymentPlanDO record);
    
    RepaymentPlanDO findRepaymentPlanById(String id);
    
    void updateRepayStsById(String id,String repaySts);
}
