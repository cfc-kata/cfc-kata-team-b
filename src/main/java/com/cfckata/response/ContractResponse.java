package com.cfckata.response;

import com.cfckata.domain.Contract;
import lombok.Data;

@Data
public class ContractResponse {
    private String id;
    private String totalPrice;
    private String totalPayment;

    public ContractResponse(Contract contract) {
    }

}
