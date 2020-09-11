package com.cfckata.controller;

import com.cfckata.domain.RepaymentDetail;
import com.cfckata.exception.RepaymentException;
import com.cfckata.request.RepaymentRequest;
import com.cfckata.response.RepaymentCreatedResponse;
import com.cfckata.service.RepaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
		
		if(StringUtils.isEmpty(request.getRepaymentPlanId())){
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
		
		RepaymentDetail repayment = repaymentService.queryRepaymentById(repaymentId);
		
		RepaymentCreatedResponse response = new RepaymentCreatedResponse(repayment);
		return response;
       
    }

}
