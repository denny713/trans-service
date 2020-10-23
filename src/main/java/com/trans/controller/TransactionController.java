package com.trans.controller;

import com.trans.entity.Transaction;
import com.trans.model.Status;
import com.trans.model.Summary;
import com.trans.model.TransModel;
import com.trans.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transactionservice")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    private static final String OK = "Ok";
    private static Status status = new Status();
    private static Summary sum = new Summary();

    @PutMapping("/transaction/{transaction_id}")
    @ResponseBody
    public Status saveTrans(@Valid @RequestBody TransModel trans, @PathVariable("transaction_id") String id) {
        try {
            Transaction transaction = new Transaction();
            transaction.setParentId(Long.valueOf(id));
            if (trans.getParentId() == null) {
                transaction.setTransId(Long.valueOf(id));
            } else {
                transaction.setTransId(trans.getParentId());
            }
            transaction.setAmount(trans.getAmount());
            transaction.setType(trans.getType());
            transactionService.saveTransaction(transaction);
            status.setStatus(OK);
        } catch (Exception d) {
            status.setStatus("Failed : " + d.getMessage());
        }
        return status;
    }

    @GetMapping("/types/{type}")
    @ResponseBody
    public List<Long> getByType(@PathVariable("type") String type) {
        return transactionService.getByType(type);
    }

    @GetMapping("/sum/{transaction_id}")
    @ResponseBody
    public Summary summaryById(@PathVariable("transaction_id") String id) {
        return transactionService.sumById(Long.valueOf(id));
    }
}
