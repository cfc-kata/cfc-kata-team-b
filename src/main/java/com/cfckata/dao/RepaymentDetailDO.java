package com.cfckata.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cfckata.domain.RepaymentDetail;

import lombok.Data;

@Data
public class RepaymentDetailDO {
	
	private String id;
	
	private String createTime;
	
	private String loanId;
	
	private String repaymentPlanId;
	
	private BigDecimal amount;
	
	private String repaymentBankAccount;
	
    private int version;
    
    private String paySerno;
    
    private String sts;
    
    public RepaymentDetailDO() {
    	
    }
	
	public RepaymentDetailDO(RepaymentDetail detail) {
		this.id = detail.getRepaymentId();
		this.createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		this.loanId = detail.getLoanId();
		this.repaymentPlanId = detail.getRepaymentPlanId();
		this.amount = detail.getAmount();
		this.repaymentBankAccount = detail.getRepaymentBankAccount();
		this.version = detail.getVersion();
		this.paySerno = detail.getPaySerno();
		this.sts = detail.getSts();
	}
	
	
	public RepaymentDetail toRepaymentDetail() {
		RepaymentDetail detail = new RepaymentDetail();
		
		detail.setAmount(this.getAmount());
		detail.setCreatedTime(this.getCreateTime());
		detail.setLoanId(this.getLoanId());
		detail.setRepaymentBankAccount(this.getRepaymentBankAccount());
		detail.setRepaymentId(this.getId());
		detail.setRepaymentPlanId(this.getRepaymentPlanId());
		detail.setVersion(this.getVersion());
		detail.setSts(this.getSts());
		detail.setPaySerno(this.getPaySerno());
		return detail;
	}
}
