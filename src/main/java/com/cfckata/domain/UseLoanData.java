package com.cfckata.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UseLoanData implements Serializable {

    private String loanId;

    private String contractId;

    private String applyAmount;

    private String totalMonth;

    private String interestRate;

    private String withdrawBankAccount;

    private String repaymentBankAccount;

    private String repaymentType;

    List<UseLoanItem> repaymentPlans;
}
