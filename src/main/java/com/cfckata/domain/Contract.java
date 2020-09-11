package com.cfckata.domain;

import com.github.meixuesong.aggregatepersistence.Versionable;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Contract implements Versionable {

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

    @Override
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
