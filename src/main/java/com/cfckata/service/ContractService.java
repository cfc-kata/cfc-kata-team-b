package com.cfckata.service;

import com.cfckata.domain.Contract;
import com.cfckata.request.CreateContractRequest;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    public Contract findById(String contractId) {
        Contract contract = new Contract();
        contract.setContractId(contractId);
        return contract;
    }

    public Contract createContract(CreateContractRequest request) {
        Contract contract = new Contract();
       return contract;
    }

}
