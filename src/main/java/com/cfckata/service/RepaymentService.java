package com.cfckata.service;

import org.springframework.stereotype.Service;

import com.cfckata.domain.Repayment;
import com.cfckata.proxy.RepayProxy;

@Service
public class RepaymentService {
	
	
	private RepayProxy repayProxy;
	
	public RepaymentService(RepayProxy repayProxy){
		this.repayProxy = repayProxy;
	}
	
	/**
	 * 根据扣款流水号查询扣款详情
	 * @param repaymentId
	 * @return
	 */
	public  Repayment queryRepaymentById(String repaymentId){
		
		Repayment repayment = new Repayment();
		
		//TODO
		return repayment;
		
	}
	
	/**
	 * 根据还款计划行ID进行单笔扣款
	 * @param repaymentPlanId
	 * @return
	 */
	public Repayment doRepaymentByPlanId(String repaymentPlanId){
         Repayment repayment = new Repayment();
         
         repayProxy.repay(repayment.getRepaymentBankAccount(), repayment.getAmount()); 
         
		return repayment;
		
	}
}
