package com.cfckata.request;

import com.cfckata.domain.Customer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class CreateContractRequest {

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
    private BigDecimal commitment;

}
