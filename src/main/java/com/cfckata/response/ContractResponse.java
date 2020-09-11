package com.cfckata.response;

import com.cfckata.domain.Contract;
import lombok.Data;

@Data
public class ContractResponse {

    /**
     * 合同id
     */
    private String id;

    /**
     * 客户id
     */
    private String customerId;

    /**
     * 期限
     */
    private Integer term;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 额度
     */
    private Integer limit;

    public ContractResponse() {
    }

    public ContractResponse(Contract contract) {
        this.id = contract.getId();
        this.customerId = contract.getCustomerId();
        this.age = contract.getAge();
        this.limit = contract.getLimit();
        this.term = contract.getTerm();
    }
}
