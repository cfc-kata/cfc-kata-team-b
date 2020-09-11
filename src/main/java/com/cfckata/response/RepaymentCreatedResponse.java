package com.cfckata.response;

import java.math.BigDecimal;

public class RepaymentCreatedResponse {
	
	//扣款流水号
	private String repaymentId;
	//创建时间
	private String createdTime;
	//合同号
	private String contractId;
	//还款计划行ID
	private String repaymentPlanId;
	//还款金额
	private BigDecimal amount;
	//还款卡号
	private String repaymentBankAccount;
	
	
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
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
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
