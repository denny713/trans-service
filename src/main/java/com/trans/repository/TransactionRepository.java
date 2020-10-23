package com.trans.repository;

import com.trans.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    public Transaction findFirstByOrderByTransIdDesc();
}
