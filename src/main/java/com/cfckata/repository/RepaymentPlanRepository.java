package com.cfckata.repository;

import org.springframework.stereotype.Repository;

import com.cfckata.domain.RepaymentPlan;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

@Repository
public class RepaymentPlanRepository {
	
	
	/**
	 * 根据还款计划id查询还款计划
	 * @param id
	 * @return
	 */
	public Aggregate<RepaymentPlan> findById(String id) {
		
		
		RepaymentPlan repaymentPlan = new RepaymentPlan();
				
        return AggregateFactory.createAggregate(repaymentPlan);
    }
}
