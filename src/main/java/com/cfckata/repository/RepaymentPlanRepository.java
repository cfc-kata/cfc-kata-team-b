package com.cfckata.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cfckata.dao.RepaymentPlanDO;
import com.cfckata.dao.RepaymentPlanDOMapper;
import com.cfckata.domain.RepaymentPlan;
import com.cfckata.exception.RepaymentException;

@Repository
public class RepaymentPlanRepository {
	
	@Autowired
	private RepaymentPlanDOMapper repaymentPlanDOMapper;
	
	
	/**
	 * 根据还款计划id查询还款计划
	 * @param id
	 * @return
	 */
	public RepaymentPlan findById(String id) {
		RepaymentPlanDO repaymentPlanDO = repaymentPlanDOMapper.findRepaymentPlanById(id);
		if(repaymentPlanDO == null){
			 throw new RepaymentException("根据id无法查询到对应的还款计划信息!");
		 }
        return repaymentPlanDO.toRepaymentPlan();
    }
	
	/**
	 * 根据还款日期查询还款计划
	 * @param id
	 * @return
	 */
	public List<RepaymentPlan> findByRepaymentDate(String repaymentDate) {
		List<RepaymentPlanDO> repaymentPlanDOList = repaymentPlanDOMapper.findListByRepaymentDate(repaymentDate);
		if(repaymentPlanDOList == null || repaymentPlanDOList.size() == 0){
			 throw new RepaymentException("根据id无法查询到对应的还款计划信息!");
		 }
		
        return repaymentPlanDOList.stream()
                .map(repaymentPlanDO -> {
                    return repaymentPlanDO.toRepaymentPlan();
                })
                .collect(Collectors.toList());
    }
	
	/**
	 * 根据id更新还款计划状态
	 * @param id
	 * @param repaySts
	 */
	public void updateRepayStsById(String id,String repaySts) {
		repaymentPlanDOMapper.updateRepayStsById(id, repaySts);
	}
	
	
}
