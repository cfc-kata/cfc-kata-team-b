package com.cfckata.request;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UseLoanQueryRequest implements Serializable {

    /**
     *  提款申请流水号
	 */
	private String loanId;


}
