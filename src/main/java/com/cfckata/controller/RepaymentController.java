package com.cfckata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RepaymentCreatedResponse repayByPlanId(@RequestBody RepaymentRequest request) {
		
		RepaymentCreatedResponse response = new RepaymentCreatedResponse();
		return response;
       
    }
	
	
	@GetMapping("/{repaymentId}")
    public RepaymentCreatedResponse queryRepaymentInfoByRepaymentId(@PathVariable String repaymentId) {
		
		RepaymentCreatedResponse response = new RepaymentCreatedResponse();
		return response;
       
    }

}
