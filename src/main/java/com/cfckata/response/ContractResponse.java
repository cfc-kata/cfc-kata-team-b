package com.cfckata.response;

import cn.hutool.core.bean.BeanUtil;
import com.cfckata.domain.Contract;
import com.cfckata.domain.Customer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContractResponse {

    /**
     * 合同id
     */
    private String contractId;

    /**
     * 客户信息
     */
    private Customer customer;

    /**
     * 利率
     */
    private BigDecimal interestRate;

    /**
     * 还款方式
     */
    private String repaymentType;

    /**
     * 到期日
     */
    private String maturityDate;

    /**
     * 额度
     */
    private String commitment;

    /**
     * 状态
     */
    private String status;

    private int version;

    public ContractResponse() {
    }

    public ContractResponse(Contract contract) {
        BeanUtil.copyProperties(contract, this);
    }
}
