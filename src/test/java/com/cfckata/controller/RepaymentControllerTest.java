package com.cfckata.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cfckata.common.ApiTest;
import com.cfckata.request.RepaymentRequest;
import com.cfckata.response.RepaymentCreatedResponse;

public class RepaymentControllerTest extends ApiTest {

	@Test
	public void shouldQueryRepaymentInfoByRepaymentId() {

		String repaymentId = "001";

		ResponseEntity<RepaymentCreatedResponse> responseEntity = this.restTemplate
				.getForEntity(baseUrl + "/repayments/" + repaymentId, RepaymentCreatedResponse.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		RepaymentCreatedResponse repayment = responseEntity.getBody();
		assertNotNull(repayment);

	}
	
	@Test
	public void shouldRepaymentCreateSuccess() {
		RepaymentRequest request = new RepaymentRequest();
		request.setRepaymentPlanId("234234234");

		ResponseEntity<RepaymentCreatedResponse> responseEntity = this.restTemplate
				.postForEntity(baseUrl + "/repayments", request, RepaymentCreatedResponse.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		RepaymentCreatedResponse repayment = responseEntity.getBody();
		assertNotNull(repayment);

	}

}
