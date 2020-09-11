package com.cfckata.controller;

import com.cfckata.common.ApiTest;
import com.cfckata.domain.Contract;
import com.cfckata.domain.Customer;
import com.cfckata.request.CreateContractRequest;
import com.cfckata.response.ContractResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ContractControllerTest extends ApiTest {

    @Test
    public void should_support_query_contract() {
        //Given
        String contractId = "aaa";
        ResponseEntity<ContractResponse> responseEntity = this.restTemplate.getForEntity(baseUrl + "/contracts/" + contractId, ContractResponse.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        ContractResponse response = responseEntity.getBody();
        assertThat(response.getContractId()).isEqualTo(contractId);
    }

    @Test
    //@Sql(scripts = "classpath:sql/order-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    //@Sql(scripts = "classpath:sql/order-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void should_support_create_contract() {
        //Given
        CreateContractRequest request = new CreateContractRequest();
        Customer customer = new Customer();
        customer.setId("BJ001")
                .setName("张三")
                .setIdnumber("412829198812280101")
                .setMobilePhone("13000001111");
        request.setCustomer(customer)
        .setInterestRate(new BigDecimal("9.9"))
        .setRepaymentType("DEBX")
        .setMaturityDate("2022-05-01")
        .setCommitment(new BigDecimal("10000"));

        //When
        ResponseEntity<ContractResponse> responseEntity = this.restTemplate.postForEntity(baseUrl + "/contracts", request, ContractResponse.class);

        //Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        ContractResponse contract = responseEntity.getBody();
        assertThat(contract).isNotNull();
    }

}
