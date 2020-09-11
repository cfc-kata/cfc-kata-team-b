package com.cfckata.response;

import lombok.Data;

@Data
public class UseLoanItemResponse {

    /**
     * 还款计划id
     */
    private String planId;
    /**
     * 期数
     */
    private String periodNo;
    private String payableDate;
    private String payableAmount;
    private String payableInterest;
    private String payableCapital;
    private String status;
}
