package com.trans.service.implement;

import com.trans.entity.Transaction;
import com.trans.repository.TransactionRepository;
import com.trans.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImplement implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction getNewestTransaction() {
        return transactionRepository.findFirstByOrderByTransIdDesc();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
