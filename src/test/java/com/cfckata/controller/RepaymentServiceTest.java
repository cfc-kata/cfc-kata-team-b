package com.cfckata.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cfckata.common.SpringServiceTest;
import com.cfckata.domain.RepaymentDetail;
import com.cfckata.domain.RepaymentPlan;
import com.cfckata.exception.RepaymentException;
import com.cfckata.proxy.RepaymentProxy;
import com.cfckata.repository.RepaymentDetailRepository;
import com.cfckata.repository.RepaymentPlanRepository;
import com.cfckata.service.RepaymentService;

public class RepaymentServiceTest extends SpringServiceTest{
	
	private RepaymentPlanRepository repaymentPlanRepository;
	
	private RepaymentDetailRepository repaymentDetailRepository;
	
	private RepaymentProxy rapaymentProxy;
	
	private RepaymentService repaymentService;
	
	private RepaymentPlan repaymentPlan;
	
	private List<RepaymentPlan> repaymentPlanList;
	
	private RepaymentDetail repaymentDetail;
	
	@Before
    public void setUp() throws Exception {
		rapaymentProxy = mock(RepaymentProxy.class);
		repaymentPlanRepository = mock(RepaymentPlanRepository.class);
		repaymentDetailRepository = mock(RepaymentDetailRepository.class);
        repaymentService = new RepaymentService(rapaymentProxy, repaymentPlanRepository,repaymentDetailRepository);
        
        repaymentPlan = new RepaymentPlan();
        
        repaymentPlan.setDueDt("2020-09-12");
        repaymentPlan.setId("PLAN2020091500002");
        repaymentPlan.setLoanId("LOAN0220091400000002");
        repaymentPlan.setPrcpAmt(new BigDecimal("230"));
        repaymentPlan.setPrcpInt(new BigDecimal("20"));
        repaymentPlan.setRepaymentBankAccount("6225883719240035");
        repaymentPlan.setRepaySts("NORM");
        repaymentPlan.setTermNo("1");
        repaymentPlan.setVersion(1);
        
        repaymentPlanList = new ArrayList<RepaymentPlan>();
        repaymentPlanList.add(repaymentPlan);

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
    
    @Test
    public void should_repay_batch_success() {
        //Given
    	String repaymentDate = "2020-09-12";
    	when(repaymentPlanRepository.findById(any())).thenReturn(repaymentPlan);
    	when(repaymentPlanRepository.findByRepaymentDate(any())).thenReturn(repaymentPlanList);
    	doNothing().when(repaymentDetailRepository).insert(any());
    	doNothing().when(repaymentPlanRepository).updateRepayStsById(anyString(), anyString());
    	doThrow(new RepaymentException("error001","余额不足")).when(rapaymentProxy).repay(anyString(), any());
        //When
    	List<RepaymentDetail> detailList = repaymentService.batchRepayByRepaymentDate(repaymentDate);

        //THEN
        assertThat(detailList.size()).isEqualTo(1);
        assertThat(detailList.get(0).getErrorCode()).isEqualTo("error001");
    }
}
