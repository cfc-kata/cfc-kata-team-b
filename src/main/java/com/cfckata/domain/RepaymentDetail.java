package com.cfckata.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RepaymentDetail {
	//扣款流水号
		private String repaymentId;
		//创建时间
		private String createdTime;
		//借据号
		private String iouId;
		//还款计划行ID
		private String repaymentPlanId;
		//还款金额
		private BigDecimal amount;
		//还款卡号
		private String repaymentBankAccount;
}
