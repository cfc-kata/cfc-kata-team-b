package com.cfckata.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseLoanApplRequest implements Serializable {

	/**
	 *  合同号
	 */
	private String contractId;

	/**
	 *  提款金额
	 */
	private String applyAmount;

	/**
	 *  提款期限
	 */
	private String totalMonth;

	/**
	 *  执行利率
	 */
	private String interestRate;

	/**
	 * 取款卡号
	 */
	private String withdrawBankAccount;

	/**
	 * 还款/扣款卡号
	 */
	private String repaymentBankAccount;

	/**
	 * 还款方式
	 */
	private String repaymentType;

}
