package com.cfckata.domain;

import java.math.BigDecimal;

import com.github.meixuesong.aggregatepersistence.Versionable;

import lombok.Data;

@Data
public class RepaymentPlan implements Versionable{

	// 借据号
	private String iouId;
	// 还款计划行ID
	private String id;
	// 应还款日
	private String dueDt;
	
	// 还款金额
	private BigDecimal prcpAmt = BigDecimal.ZERO;
	// 还款利息
	private BigDecimal prcpInt = BigDecimal.ZERO;
	
	// 应还款日
    private String repaymentBankAccount;
	
    private int version;
	
	@Override
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
	
	/**
	 * 汇总每期还款计划的总期供
	 * @return
	 */
	public BigDecimal totalPeriodAmt(){

		return this.prcpAmt.add(this.prcpInt);
	}
			
}
