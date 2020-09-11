package com.cfckata.response;

import java.util.List;

public class RepaymentBatchResponse {
	
	private List<RepaymentCreatedResponse> successItems;
	
	private List<RepaymentFailedResponse> failedItems;

	public List<RepaymentCreatedResponse> getSuccessItems() {
		return successItems;
	}

	public void setSuccessItems(List<RepaymentCreatedResponse> successItems) {
		this.successItems = successItems;
	}

	public List<RepaymentFailedResponse> getFailedItems() {
		return failedItems;
	}

	public void setFailedItems(List<RepaymentFailedResponse> failedItems) {
		this.failedItems = failedItems;
	}
	
	
	
}
