package com.cfckata.proxy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RepaymentProxy {
	
	/**
	 * 调用支付还款接口
	 * @param repayCardId
	 * @param amount
	 */
	public String repay(String repayCardId, BigDecimal amount) {
        //Call exteranl services
		
		return "123123123";
    }
}
