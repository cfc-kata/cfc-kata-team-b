package com.cfckata.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cfckata.domain.RepaymentPlan;

import lombok.Data;

@Data
public class RepaymentPlanDO {
	
    private String id;
	
	private String createTime;
	
	private String loanId;
	
	private String dueDt;
	
	private String termNo;
	
	private BigDecimal prcpAmt;
	
	private BigDecimal prcpInt;
	
	private String repaymentBankAccount;
	
    private int version;
    
    private String repaySts;
	
    public RepaymentPlanDO(){}
	
	public RepaymentPlanDO(RepaymentPlan plan) {
		this.id = plan.getId();
		this.createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		this.loanId = plan.getLoanId();
		this.dueDt = plan.getDueDt();
		this.termNo = plan.getTermNo();
		this.prcpAmt = plan.getPrcpAmt();
		this.prcpInt = plan.getPrcpInt();
		this.repaymentBankAccount = plan.getRepaymentBankAccount();
		this.version = plan.getVersion();
		this.repaySts = plan.getRepaySts();
	}
	
	
	public RepaymentPlan toRepaymentPlan() {
		RepaymentPlan plan = new RepaymentPlan();
		plan.setDueDt(dueDt);
		plan.setId(id);
		plan.setLoanId(loanId);
		plan.setPrcpAmt(prcpAmt);
		plan.setPrcpInt(prcpInt);
		plan.setRepaymentBankAccount(repaymentBankAccount);
		plan.setTermNo(termNo);
		plan.setVersion(version);
		plan.setRepaySts(repaySts);
		
		return plan;
	}
}
