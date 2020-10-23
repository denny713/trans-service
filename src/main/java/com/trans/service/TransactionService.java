package com.trans.service;

import com.trans.entity.Transaction;
import com.trans.model.Summary;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TransactionService {

    public void saveTransaction(Transaction transaction);

    public List<Long> getByType(String type);

    public Summary sumById(Long id);
}
