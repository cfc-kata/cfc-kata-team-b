package com.cfckata.service;

import com.cfckata.domain.Contract;
import com.cfckata.request.CreateContractRequest;
import com.github.meixuesong.aggregatepersistence.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    private ContractFactory contractFactory;

    public Contract findById(String contractId) {
        Contract contract = new Contract();
        contract.setContractId(contractId);
        return contract;
    }

    public String createContract(CreateContractRequest request) {
        Aggregate<Contract> aggregate = contractFactory.createContract(request);
        return aggregate.getRoot().getContractId();
    }

}
