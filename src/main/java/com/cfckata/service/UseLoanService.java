package com.cfckata.service;


import com.cfckata.domain.UseLoanData;
import com.cfckata.request.UseLoanApplRequest;
import com.cfckata.request.UseLoanQueryRequest;
import org.springframework.stereotype.Service;

@Service
public class UseLoanService {


    /**
     *  提款
     * @param request
     * @return
     */
    public UseLoanData createLoan(UseLoanApplRequest request){
        UseLoanData useLoanData = new UseLoanData();
        useLoanData.setLoanId("111");
        return useLoanData;
    }


    /**
     * 查询提款信息
     * @param loanId
     * @return
     */
    public UseLoanData findLoan(String loanId){
        UseLoanData useLoanData = new UseLoanData();
        useLoanData.setLoanId(loanId);
        return useLoanData;
    }

}
