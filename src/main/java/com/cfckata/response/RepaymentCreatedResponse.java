package com.cfckata.response;

import java.math.BigDecimal;

import com.cfckata.domain.RepaymentDetail;

public class RepaymentCreatedResponse {
	
	//扣款流水号
	private String repaymentId;
	//创建时间
	private String createdTime;
	//借据号
	private String loanId;
	//还款计划行ID
	private String repaymentPlanId;
	//还款金额
	private BigDecimal amount;
	//还款卡号
	private String repaymentBankAccount;
	
	public RepaymentCreatedResponse(){
	}
	
	public RepaymentCreatedResponse(RepaymentDetail repayment){
		this.repaymentId = repayment.getRepaymentId();
		this.createdTime = repayment.getCreatedTime();
		this.loanId = repayment.getLoanId();
		this.repaymentPlanId = repayment.getRepaymentPlanId();
		this.amount = repayment.getAmount();
		this.repaymentBankAccount = repayment.getRepaymentBankAccount();
	}
	
	
	public String getRepaymentId() {
		return repaymentId;
	}
	public void setRepaymentId(String repaymentId) {
		this.repaymentId = repaymentId;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	public String getLoanId() {
		return loanId;
	}


	public void setIouId(String loanId) {
		this.loanId = loanId;
	}


	public String getRepaymentPlanId() {
		return repaymentPlanId;
	}
	public void setRepaymentPlanId(String repaymentPlanId) {
		this.repaymentPlanId = repaymentPlanId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getRepaymentBankAccount() {
		return repaymentBankAccount;
	}
	public void setRepaymentBankAccount(String repaymentBankAccount) {
		this.repaymentBankAccount = repaymentBankAccount;
	}
	
	
}
