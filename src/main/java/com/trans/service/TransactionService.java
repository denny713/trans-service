package com.trans.service;

import com.trans.entity.Transaction;

import javax.transaction.Transactional;

@Transactional
public interface TransactionService {

    public Transaction getNewestTransaction();

    public void saveTransaction(Transaction transaction);
}
