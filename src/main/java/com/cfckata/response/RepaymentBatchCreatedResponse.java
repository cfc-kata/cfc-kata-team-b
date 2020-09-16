package com.cfckata.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.cfckata.domain.RepaymentDetail;

import lombok.Data;

@Data
public class RepaymentBatchCreatedResponse {
	
	List<RepaymentCreatedResponse> successItems = new ArrayList<RepaymentCreatedResponse>();
	
	List<RepaymentCreatedResponse> failedItems = new ArrayList<RepaymentCreatedResponse>();
	
	public RepaymentBatchCreatedResponse() {}
	
	public RepaymentBatchCreatedResponse(List<RepaymentDetail> detailList) {
		for(RepaymentDetail detail : detailList) {
			if(StringUtils.isEmpty(detail.getErrorCode())){
				successItems.add(new RepaymentCreatedResponse(detail));
			}else{
				failedItems.add(new RepaymentCreatedResponse(detail));
			}
				
		}
	}
}
