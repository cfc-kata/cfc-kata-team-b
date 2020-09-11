package com.cfckata.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UseLoanQueryRequest implements Serializable {

    /**
     *  提款申请流水号
	 */
	private String loanId;


}
