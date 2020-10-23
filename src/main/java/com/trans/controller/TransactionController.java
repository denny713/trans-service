package com.trans.controller;

import com.trans.entity.Transaction;
import com.trans.model.request.TransInput;
import com.trans.model.response.Status;
import com.trans.model.response.Summary;
import com.trans.service.TransactionService;
import com.trans.util.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Status saveTrans(@Valid @RequestBody TransInput trans, @PathVariable("transaction_id") String id) {
        try {
            Transaction transaction = new Transaction();
            Transaction maxId = transactionService.getNewestTransaction();
            String ids = "";
            if (maxId == null) {
                ids = "-";
            } else {
                ids = maxId.getTransId();
            }
            transaction.setTransId(Function.generateTransId(ids));
            transaction.setParentId(Long.valueOf(id));
            transaction.setAmount(trans.getAmount());
            transaction.setType(trans.getType());
            transactionService.saveTransaction(transaction);
            status.setStatus(OK);
        } catch (Exception d) {
            status.setStatus("Failed : " + d.getMessage());
        }
        return status;
    }
}
