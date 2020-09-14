package com.cfckata.service;

import org.springframework.stereotype.Service;

import com.cfckata.common.RepayEnum;
import com.cfckata.domain.RepaymentDetail;
import com.cfckata.domain.RepaymentPlan;
import com.cfckata.exception.RepaymentException;
import com.cfckata.proxy.RepaymentProxy;
import com.cfckata.repository.RepaymentDetailRepository;
import com.cfckata.repository.RepaymentPlanRepository;

@Service
public class RepaymentService {
	
	
	private RepaymentProxy repaymentProxy;
	
	private RepaymentPlanRepository repaymentPlanRepository;
	
	private RepaymentDetailRepository repaymentDetailRepository;
	
		
	public RepaymentService(RepaymentProxy repaymentProxy,RepaymentPlanRepository repaymentPlanRepository,RepaymentDetailRepository repaymentDetailRepository){
		this.repaymentProxy = repaymentProxy;
		this.repaymentPlanRepository = repaymentPlanRepository;
		this.repaymentDetailRepository = repaymentDetailRepository;
	}
	
	/**
	 * 根据扣款流水号查询扣款详情
	 * @param repaymentId
	 * @return
	 */
	public  RepaymentDetail queryRepaymentById(String repaymentId){		
		return repaymentDetailRepository.findRepaymentDetailById(repaymentId);
	}
	
	/**
	 * 根据还款计划行ID进行单笔扣款
	 * @param repaymentPlanId
	 * @return
	 */
	public RepaymentDetail doRepaymentByPlanId(String repaymentPlanId){
		 //根据还款计划ID查询还款计划
		 RepaymentPlan repaymentPlan = repaymentPlanRepository.findById(repaymentPlanId);
		 		 
		 //调用支付系统还款接口，并返回支付流水号
         String repaymentId = repaymentProxy.repay(repaymentPlan.getRepaymentBankAccount(), repaymentPlan.totalPeriodAmt());
         //生成支付明细信息
		 RepaymentDetail repaymentDetail = new RepaymentDetail();
         repaymentDetail.setRepaymentId(repaymentId);
         repaymentDetail.setAmount(repaymentPlan.totalPeriodAmt());
         repaymentDetail.setLoanId(repaymentPlan.getLoanId());
         repaymentDetail.setRepaymentBankAccount(repaymentPlan.getRepaymentBankAccount());
         repaymentDetail.setRepaymentPlanId(repaymentPlan.getId());
         repaymentDetailRepository.insert(repaymentDetail);
         
         //更新还款状态
         repaymentPlanRepository.updateRepayStsById(repaymentPlanId, RepayEnum.SETL.getCode());
         
		return repaymentDetail;
		
	}
}
