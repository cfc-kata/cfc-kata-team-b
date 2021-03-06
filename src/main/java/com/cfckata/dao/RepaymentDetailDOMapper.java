package com.cfckata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RepaymentDetailDOMapper {
    int insert(RepaymentDetailDO record);
    
    RepaymentDetailDO findRepaymentDetailById(String id);
}
