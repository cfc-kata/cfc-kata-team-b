package com.cfckata.service;

import org.springframework.stereotype.Service;

import com.cfckata.domain.RepaymentDetail;
import com.cfckata.domain.RepaymentPlan;
import com.cfckata.proxy.RepaymentProxy;
import com.cfckata.repository.RepaymentPlanRepository;
import com.github.meixuesong.aggregatepersistence.Aggregate;

@Service
public class RepaymentService {
	
	
	private RepaymentProxy repaymentProxy;
	
	private RepaymentPlanRepository repaymentPlanRepository;
	
		
	public RepaymentService(RepaymentProxy repaymentProxy,RepaymentPlanRepository repaymentPlanRepository){
		this.repaymentProxy = repaymentProxy;
		this.repaymentPlanRepository = repaymentPlanRepository;
	}
	
	/**
	 * 根据扣款流水号查询扣款详情
	 * @param repaymentId
	 * @return
	 */
	public  RepaymentDetail queryRepaymentById(String repaymentId){
		
		RepaymentDetail repaymentDetail = new RepaymentDetail();
		
		//TODO
		return repaymentDetail;
		
	}
	
	/**
	 * 根据还款计划行ID进行单笔扣款
	 * @param repaymentPlanId
	 * @return
	 */
	public RepaymentDetail doRepaymentByPlanId(String repaymentPlanId){
		 RepaymentDetail repaymentDetail = new RepaymentDetail();
		 		 
		 Aggregate<RepaymentPlan> repaymentPlanAggregate = repaymentPlanRepository.findById(repaymentPlanId);
		 
		 RepaymentPlan repaymentPlan = repaymentPlanAggregate.getRoot();
		 
         String repaymentId = repaymentProxy.repay(repaymentPlan.getRepaymentBankAccount(), repaymentPlan.totalPeriodAmt());
         
         repaymentDetail.setRepaymentId(repaymentId);
         repaymentDetail.setAmount(repaymentPlan.totalPeriodAmt());
         repaymentDetail.setIouId(repaymentPlan.getIouId());
         repaymentDetail.setRepaymentBankAccount(repaymentPlan.getRepaymentBankAccount());
         repaymentDetail.setRepaymentPlanId(repaymentPlan.getId());
         
		return repaymentDetail;
		
	}
}
