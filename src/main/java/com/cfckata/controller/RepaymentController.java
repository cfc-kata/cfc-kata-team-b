package com.cfckata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cfckata.domain.RepaymentDetail;
import com.cfckata.exception.RepaymentException;
import com.cfckata.request.RepaymentRequest;
import com.cfckata.response.RepaymentBatchCreatedResponse;
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
		
		if(StringUtils.isEmpty(request.getRepaymentPlanId())){
			throw new RepaymentException("请求信息不能为空");
		}
		
		RepaymentDetail detail = repaymentService.doRepaymentByPlanId(request.getRepaymentPlanId());
		
		if(!StringUtils.isEmpty(detail.getErrorCode())){
			return new RepaymentCreatedResponse(detail.getErrorCode(), detail.getErrorMessage());
		}
		
		return new RepaymentCreatedResponse(detail);
    }
	
	/**
	 * 批量扣款
	 * @param request
	 * @return
	 */
	@GetMapping("/batch/{repaymentDate}")
    public RepaymentBatchCreatedResponse batchRepayByRepaymentDate(@PathVariable String repaymentDate) {
		
		if(StringUtils.isEmpty(repaymentDate)){
			throw new RepaymentException("获取参数批量日期失败");
		}

		return new RepaymentBatchCreatedResponse(repaymentService.batchRepayByRepaymentDate(repaymentDate));  
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
