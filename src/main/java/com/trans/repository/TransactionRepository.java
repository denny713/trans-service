package com.trans.repository;

import com.trans.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public List<Transaction> findByTypeOrderByParentId(String type);

    public List<Transaction> findByTransId(Long transId);

    public Transaction findByParentId(Long parentId);
}
