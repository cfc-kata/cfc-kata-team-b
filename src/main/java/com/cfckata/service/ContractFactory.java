package com.cfckata.service;


import cn.hutool.core.bean.BeanUtil;
import com.cfckata.domain.Contract;
import com.cfckata.request.CreateContractRequest;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import com.github.meixuesong.aggregatepersistence.AggregateFactory;
import org.springframework.stereotype.Service;

@Service
public class ContractFactory {

    public ContractFactory() {
    }

    public Aggregate<Contract> createContract(CreateContractRequest request) {
        Contract contract = BeanUtil.copyProperties(request, Contract.class);
        contract.create();
        return AggregateFactory.createAggregate(contract);
    }

}
