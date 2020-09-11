package com.cfckata.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateContractRequest {

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

}
