package com.cfckata.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.ApiTest;
import com.cfckata.request.RepaymentRequest;
import com.cfckata.response.RepaymentCreatedResponse;

public class RepaymentControllerTest extends ApiTest {

	@Test
	@Sql(scripts = "classpath:sql/repayment-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/repayment-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void shouldQueryRepaymentInfoByRepaymentId() {
		String repaymentId = "DETAIL2020091400002";
		ResponseEntity<RepaymentCreatedResponse> responseEntity = this.restTemplate
				.getForEntity(baseUrl + "/repayments/" + repaymentId, RepaymentCreatedResponse.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		RepaymentCreatedResponse repayment = responseEntity.getBody();
		assertNotNull(repayment);

	}
	
	@Test
	@Sql(scripts = "classpath:sql/repayment-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/repayment-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void shouldRepaymentCreateSuccess() {
		RepaymentRequest request = new RepaymentRequest();
		request.setRepaymentPlanId("PLAN2020091400006");

		ResponseEntity<RepaymentCreatedResponse> responseEntity = this.restTemplate
				.postForEntity(baseUrl + "/repayments", request, RepaymentCreatedResponse.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		RepaymentCreatedResponse repayment = responseEntity.getBody();
		assertNotNull(repayment);

	}

}
