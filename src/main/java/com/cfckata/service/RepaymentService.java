package com.cfckata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfckata.common.RepayEnum;
import com.cfckata.domain.RepaymentDetail;
import com.cfckata.domain.RepaymentPlan;
import com.cfckata.exception.RepaymentException;
import com.cfckata.proxy.RepaymentProxy;
import com.cfckata.repository.RepaymentDetailRepository;
import com.cfckata.repository.RepaymentPlanRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RepaymentService {
	
	
	private RepaymentProxy repaymentProxy;
	
	private RepaymentPlanRepository repaymentPlanRepository;
	
	private RepaymentDetailRepository repaymentDetailRepository;
	
		
	public RepaymentService(RepaymentProxy repaymentProxy, RepaymentPlanRepository repaymentPlanRepository,
			RepaymentDetailRepository repaymentDetailRepository) {
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
	 * 
	 * @param repaymentPlan
	 * @return
	 */
	public RepaymentDetail handlerRepayment(RepaymentPlan repaymentPlan){
		RepaymentDetail repaymentDetail = new RepaymentDetail();
        repaymentDetail.setRepaymentId(UUID.randomUUID().toString().replace("-", ""));
        repaymentDetail.setAmount(repaymentPlan.totalPeriodAmt());
        repaymentDetail.setLoanId(repaymentPlan.getLoanId());
        repaymentDetail.setRepaymentBankAccount(repaymentPlan.getRepaymentBankAccount());
        repaymentDetail.setRepaymentPlanId(repaymentPlan.getId());
        repaymentDetail.setSts(RepayEnum.SUCCESS.getCode());		 
		 //调用支付系统还款接口，并返回支付流水号
        String paySerno = null;
        try{
       	 paySerno = repaymentProxy.repay(repaymentPlan.getRepaymentBankAccount(), repaymentPlan.totalPeriodAmt());
            repaymentDetail.setPaySerno(paySerno);
            //生成支付明细信息
            repaymentDetailRepository.insert(repaymentDetail);
            
            //更新还款状态
            repaymentPlanRepository.updateRepayStsById(repaymentPlan.getId(), RepayEnum.SETL.getCode());
        }catch (RepaymentException e) {
       	 log.error("调用支付系统异常", e);
       	 repaymentDetail.setSts(RepayEnum.FAIL.getCode());
       	 repaymentDetail.setErrorCode(e.getCode());
       	 repaymentDetail.setErrorMessage(e.getCodeMessage());
       	 //生成支付明细信息
            repaymentDetailRepository.insert(repaymentDetail);
		 }
        
		return repaymentDetail;
	}
	
	/**
	 * 根据还款计划行ID进行单笔扣款
	 * @param repaymentPlanId
	 * @return
	 */
	@Transactional
	public RepaymentDetail doRepaymentByPlanId(String repaymentPlanId){
		 return this.handlerRepayment(repaymentPlanRepository.findById(repaymentPlanId));
	}
	
	/**
	 * 根据还款日期进行批量扣款
	 * @param repaymentDate
	 * @return
	 */
	@Transactional
	public List<RepaymentDetail> batchRepayByRepaymentDate(String repaymentDate){
		 List<RepaymentDetail> repaymentDetailList = new ArrayList<RepaymentDetail>();
		 //根据还款日期查询还款计划列表
		 List<RepaymentPlan> repaymentPlanList = repaymentPlanRepository.findByRepaymentDate(repaymentDate);
		 //逐个调用支付	 
		 for(RepaymentPlan repaymentPlan:repaymentPlanList) {
			 repaymentDetailList.add(this.handlerRepayment(repaymentPlan));
		 }
         
		return repaymentDetailList;
		
	}
}
