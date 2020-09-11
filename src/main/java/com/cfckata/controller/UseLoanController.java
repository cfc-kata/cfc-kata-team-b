package com.cfckata.controller;


import com.cfckata.domain.UseLoanData;
import com.cfckata.request.UseLoanApplRequest;
import com.cfckata.request.UseLoanQueryRequest;
import com.cfckata.response.UseLoanApplResponse;
import com.cfckata.response.UseLoanDataResponse;
import com.cfckata.service.UseLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class UseLoanController {

    @Autowired
    private UseLoanService useLoanService;


    /**
     * 放款。钱对宇宙公司来说从来不是问题，因此只要客户提款都会自动放款。
     * 放款成功后，自动生成借据和还款计划。目前只支持等额本金还款方式。
     * 有以下规则：放款总额不能超过合同总额度；合同过期不能放款；
     * 银行支付接口失败时，本次操作失败，需要重新发起放款。
     * @param request
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UseLoanApplResponse createLoan(@RequestBody UseLoanApplRequest request) {
        UseLoanData loan = useLoanService.createLoan(request);
        return new UseLoanApplResponse(loan);
    }

    /**
     * 查询放款详情
     *
     * @param loanId
     * @return
     */
    @GetMapping("/{loanId}")
    public UseLoanDataResponse findLoan(@PathVariable String loanId) {
        UseLoanData loan = useLoanService.findLoan(loanId);
        return new UseLoanDataResponse(loan);
    }
}
