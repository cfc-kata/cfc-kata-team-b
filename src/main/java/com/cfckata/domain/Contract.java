package com.cfckata.domain;

import com.cfckata.request.CreateContractRequest;
import com.github.meixuesong.aggregatepersistence.Versionable;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
public class Contract implements Versionable {

    /**
     * 合同id
     */
    private String id;

    /**
     * 客户id
     */
    private String customerId;

    /**
     * 期限
     */
    private Integer term;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 额度
     */
    private Integer limit;

    private int version;

    @Override
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
