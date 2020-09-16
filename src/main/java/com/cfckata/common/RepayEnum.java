package com.cfckata.common;

public enum RepayEnum {
	
	NORM("NORM","正常状态"),
	SETL("SETL","结清"),
	OVERDUE("OVERDUE","逾期"),
	
	SUCCESS("SUCCESS","支付成功"),
	FAIL("FAIL","支付失败");
	
	private final String code;
    private final String description;
    
    private RepayEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
