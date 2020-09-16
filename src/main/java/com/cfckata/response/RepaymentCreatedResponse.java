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
	
	//错误码
	private String errorCode;
	//错误信息
	private String errorMessage;
	
	public RepaymentCreatedResponse(){
	}
	
	public RepaymentCreatedResponse(RepaymentDetail repayment){
		this.repaymentId = repayment.getRepaymentId();
		this.createdTime = repayment.getCreatedTime();
		this.loanId = repayment.getLoanId();
		this.repaymentPlanId = repayment.getRepaymentPlanId();
		this.amount = repayment.getAmount();
		this.repaymentBankAccount = repayment.getRepaymentBankAccount();
		this.errorCode = repayment.getErrorCode();
		this.errorMessage = repayment.getErrorMessage();
	}
	
	
	public RepaymentCreatedResponse(String errorCode,String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
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

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	
	
}
