package com.cfckata.response;

import cn.hutool.core.bean.BeanUtil;
import com.cfckata.domain.UseLoanData;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class UseLoanDataResponse {

    /**
     * 提款申请流水号
     */
    private String loanId;
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


    List<UseLoanItemResponse> repaymentPlans;


    public  UseLoanDataResponse(UseLoanData useLoanData) {
        BeanUtil.copyProperties(useLoanData, this);
    }

    public  UseLoanDataResponse() {
    }

}
