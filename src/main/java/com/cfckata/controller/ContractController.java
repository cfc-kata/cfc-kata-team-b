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

    //创建合同。有一下规则:年龄应该达到 18岁，年利率不得超过36%，
    // 期限是不得超过2年。最大额度与年龄的关系如 下:
    //        [18-20]: 1万;(20-30]:5万;(30-50]:20万;
    //        (50-60]:3万;(60-70]:1万;(70-]:0元;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ContractResponse createContract(@RequestBody CreateContractRequest request) {
        String contractId = contractService.createContract(request);
        return new ContractResponse(contractId);
    }

}
