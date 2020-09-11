package com.cfckata.controller;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.domain.Repayment;
import com.cfckata.exception.RepaymentException;
import com.cfckata.request.RepaymentRequest;
import com.cfckata.response.RepaymentCreatedResponse;
import com.cfckata.service.RepaymentService;

@RestController
@RequestMapping("/repayments")
public class RepaymentController {
	
	
	private RepaymentService repaymentService;
	
	public RepaymentController(RepaymentService repaymentService) {
        this.repaymentService = repaymentService;
    }

	/**
	 * 单笔扣款
	 * @param request
	 * @return
	 */
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RepaymentCreatedResponse repayByPlanId(@RequestBody RepaymentRequest request) {
		
		if(StringUtils.isBlank(request.getRepaymentPlanId())){
			throw new RepaymentException("请求信息不能为空");
		}
		
		repaymentService.doRepaymentByPlanId(request.getRepaymentPlanId());
		
		RepaymentCreatedResponse response = new RepaymentCreatedResponse();
		
		return response;
       
    }
	
	/**
	 * 查询扣款详情
	 * @param repaymentId
	 * @return
	 */
	@GetMapping("/{repaymentId}")
    public RepaymentCreatedResponse queryRepaymentInfoByRepaymentId(@PathVariable String repaymentId) {
		
		Repayment repayment = repaymentService.queryRepaymentById(repaymentId);
		
		RepaymentCreatedResponse response = new RepaymentCreatedResponse(repayment);
		return response;
       
    }

}
