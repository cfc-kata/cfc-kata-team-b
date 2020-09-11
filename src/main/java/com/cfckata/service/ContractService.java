package com.cfckata.service;

import com.cfckata.domain.Contract;
import com.cfckata.request.CreateContractRequest;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    public Contract createContract(CreateContractRequest request) {
        Contract contract = new Contract();
        contract.setAge(request.getAge());
        contract.setCustomerId(request.getCustomerId());
        contract.setTerm(request.getTerm());

       /* Aggregate<Contract> aggregate = factory.createOrder(request);

        orderRepository.save(aggregate);

        Aggregate<Contract> orderAggregate = orderRepository.findById(aggregate.getRoot().getId());
        return orderAggregate.getRoot();*/
       return contract;
    }
}
