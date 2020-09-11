package com.cfckata.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cfckata.common.ApiTest;
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

}
