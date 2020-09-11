package com.cfckata.controller;

import com.cfckata.common.ApiTest;
import com.cfckata.request.CreateContractRequest;
import com.cfckata.response.ContractResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        String customerId = "TEST_USER_ID";
        int age = 30;
        int term = 5;
        CreateContractRequest request = new CreateContractRequest(customerId, term, age);

        //When
        ResponseEntity<ContractResponse> responseEntity = this.restTemplate.postForEntity(baseUrl + "/contracts", request, ContractResponse.class);

        //Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        ContractResponse contract = responseEntity.getBody();
        assertThat(contract).isNotNull();
    }

}
