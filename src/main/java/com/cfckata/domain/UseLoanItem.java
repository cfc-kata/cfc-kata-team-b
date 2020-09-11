package com.cfckata.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UseLoanItem implements Serializable {

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
