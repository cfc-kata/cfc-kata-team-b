package com.cfckata.controller;

import com.cfckata.common.SpringServiceTest;
import com.cfckata.domain.Customer;
import com.cfckata.request.CreateContractRequest;
import com.cfckata.service.ContractService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ContractServiceTest extends SpringServiceTest {

    @Autowired
    private ContractService contractService;

    @Test(expected = IllegalArgumentException.class)
    public void should_failed_to_create_when_param_error() {
        //Given
        CreateContractRequest request = new CreateContractRequest();
        Customer customer = new Customer();
        customer.setId("BJ001")
                .setName("张三")
                .setIdnumber("412829198812280101")
                .setMobilePhone("13000001111");
        request.setCustomer(customer)
                .setInterestRate(new BigDecimal("50.9"))
                .setRepaymentType("DEBX")
                .setMaturityDate("2022-05-01")
                .setCommitment(new BigDecimal("10000"));

        contractService.createContract(request);
    }

}
