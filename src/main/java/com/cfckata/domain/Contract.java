package com.cfckata.domain;

import com.github.meixuesong.aggregatepersistence.Versionable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class Contract implements Versionable {

    /**
     * 合同id
     */
    private String contractId;

    /**
     * 客户信息
     */
    private Customer customer;

    /**
     * 利率
     */
    private BigDecimal interestRate;

    /**
     * 还款方式
     */
    private String repaymentType;

    /**
     * 到期日
     */
    private String maturityDate;

    /**
     * 额度
     */
    private BigDecimal commitment;

    /**
     * 状态
     */
    private String status;

    private int version;

    @Override
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Contract create() {
        this.doCheck();
        this.setContractId(UUID.randomUUID().toString());
        return this;
    }

    //创建合同。有一下规则:年龄应该达到 18岁，年利率不得超过36%，
    // 期限是不得超过2年。最大额度与年龄的关系如 下:
    //        [18-20]: 1万;(20-30]:5万;(30-50]:20万;
    //        (50-60]:3万;(60-70]:1万;(70-]:0元;
    private void doCheck() {
        Customer customer = this.getCustomer();
        if (ObjectUtils.isEmpty(customer)) {
            throw new IllegalArgumentException("Customer not exists.");
        }
        //校验年龄
        String idnumber = customer.getIdnumber();

        //校验利率

        //校验期限

        //校验年龄和额度关系

    }

}
