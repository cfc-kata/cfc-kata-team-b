package com.cfckata.response;

import cn.hutool.core.bean.BeanUtil;
import com.cfckata.domain.UseLoanData;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class UseLoanApplResponse {
    /**
     * 提款申请流水号
     */
    private String loanId;


    public UseLoanApplResponse() {
    }

    public UseLoanApplResponse(UseLoanData useLoanData) {
        BeanUtil.copyProperties(useLoanData, this);
    }

}
