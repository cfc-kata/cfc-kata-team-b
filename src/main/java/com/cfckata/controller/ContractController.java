package com.cfckata.controller;

import com.cfckata.domain.Contract;
import com.cfckata.request.CreateContractRequest;
import com.cfckata.response.ContractResponse;
import com.cfckata.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/{contractId}")
    public ContractResponse findContract(@PathVariable String contractId) {
        Contract contract = contractService.findById(contractId);
        return new ContractResponse(contract);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ContractResponse createContract(@RequestBody CreateContractRequest request) {
        String contractId = contractService.createContract(request);
        return new ContractResponse(contractId);
    }

}
