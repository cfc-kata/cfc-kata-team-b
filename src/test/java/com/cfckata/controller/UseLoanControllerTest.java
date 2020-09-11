package com.cfckata.controller;

import com.cfckata.common.ApiTest;
import com.cfckata.request.UseLoanApplRequest;
import com.cfckata.response.UseLoanApplResponse;
import com.cfckata.response.UseLoanDataResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UseLoanControllerTest extends ApiTest {

	@Test
	public void should_support_create_Loan_by_appl() {

		UseLoanApplRequest useLoanApplRequest  = new UseLoanApplRequest("1","1000","6","0.1","66203555",
				"661011","DEBX");
		//When
		ResponseEntity<UseLoanApplResponse> responseEntity = this.restTemplate.postForEntity(baseUrl + "/loans", useLoanApplRequest, UseLoanApplResponse.class);
		//Then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		UseLoanApplResponse useLoanApplResponse = responseEntity.getBody();
		assertThat(useLoanApplResponse.getLoanId()).isNotNull();
	}

	@Test
	public void should_support_query_Loan() {

		String loanId = "001";
		ResponseEntity<UseLoanDataResponse> responseEntity = this.restTemplate.getForEntity(baseUrl + "/loans/" + loanId, UseLoanDataResponse.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		UseLoanDataResponse response = responseEntity.getBody();
		assertThat(response.getLoanId()).isEqualTo(loanId);
	}


}
