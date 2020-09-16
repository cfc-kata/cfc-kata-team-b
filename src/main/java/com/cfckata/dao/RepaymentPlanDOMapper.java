package com.cfckata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RepaymentPlanDOMapper {
    int update(RepaymentPlanDO record);
    
    RepaymentPlanDO findRepaymentPlanById(String id);
    
    List<RepaymentPlanDO> findListByRepaymentDate(String repaymentDate);
    
    void updateRepayStsById(String id,String repaySts);
}
