package com.cfckata;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.SpringServiceTest;
import com.cfckata.domain.RepaymentDetail;
import com.cfckata.domain.RepaymentPlan;
import com.cfckata.proxy.RepaymentProxy;
import com.cfckata.repository.RepaymentDetailRepository;
import com.cfckata.repository.RepaymentPlanRepository;
import com.cfckata.service.RepaymentService;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;

public class RepaymentServiceTest extends SpringServiceTest{
	
	private RepaymentPlanRepository repaymentPlanRepository;
	
	private RepaymentDetailRepository repaymentDetailRepository;
	
	private RepaymentProxy rapaymentProxy;
	
	private RepaymentService repaymentService;
	
	private RepaymentPlan repaymentPlan;
	
	private RepaymentDetail repaymentDetail;
	
	@Before
    public void setUp() throws Exception {
		rapaymentProxy = new RepaymentProxy();
		repaymentPlanRepository = mock(RepaymentPlanRepository.class);
		repaymentDetailRepository = mock(RepaymentDetailRepository.class);
        repaymentService = new RepaymentService(rapaymentProxy, repaymentPlanRepository,repaymentDetailRepository);
        
        repaymentPlan = new RepaymentPlan();

        repaymentDetail = new RepaymentDetail();
    }

    @Test
    public void should_repay_success() {
        //Given
    	String repaymentId = "PLAN2020091400006";
    	when(repaymentPlanRepository.findById(same(repaymentId))).thenReturn(repaymentPlan);
    	doNothing().when(repaymentDetailRepository).insert(any());
    	doNothing().when(repaymentPlanRepository).updateRepayStsById(anyString(), anyString());
    	 
        //When
        RepaymentDetail repaymentDetail = repaymentService.doRepaymentByPlanId(repaymentId);

        //THEN
        assertNotNull(repaymentDetail);
    }
}
