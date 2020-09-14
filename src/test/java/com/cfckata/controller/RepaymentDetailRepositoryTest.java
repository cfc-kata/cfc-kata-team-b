package com.cfckata.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.cfckata.common.RepositoryTest;
import com.cfckata.domain.RepaymentDetail;
import com.cfckata.repository.RepaymentDetailRepository;

public class RepaymentDetailRepositoryTest extends RepositoryTest {
    @Autowired
    private RepaymentDetailRepository repaymentDetailRepository;

    @Test
    @Sql(scripts = "classpath:sql/repayment-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/repayment-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void should_save_order() {
        String repaymentId = "DETAIL2020091400001";
        
        RepaymentDetail detail = repaymentDetailRepository.findRepaymentDetailById(repaymentId);
        
        assertThat(detail.getAmount()).isEqualByComparingTo(new BigDecimal("321"));
    }

    
}
