package com.cfckata.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.cfckata.domain.RepaymentDetail;
import com.cfckata.proxy.RepaymentProxy;
import com.cfckata.repository.RepaymentPlanRepository;

public class RepaymentServiceTest {
	
	private RepaymentPlanRepository repaymentPlanRepository;
	
	private RepaymentProxy rapaymentProxy;
	
	private RepaymentService repaymentService;
	
	@Before
    public void setUp() throws Exception {
		rapaymentProxy = new RepaymentProxy();
		repaymentPlanRepository = new RepaymentPlanRepository();
        repaymentService = new RepaymentService(rapaymentProxy, repaymentPlanRepository);

    }

    @Test
    public void should_repay_success() {
        //Given
        String repaymentId = "1231";

        //When
        RepaymentDetail repaymentDetail = repaymentService.doRepaymentByPlanId(repaymentId);

        //THEN
        assertNotNull(repaymentDetail);
    }
}
