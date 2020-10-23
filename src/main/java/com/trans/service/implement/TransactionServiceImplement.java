package com.trans.service.implement;

import com.trans.entity.Transaction;
import com.trans.model.Summary;
import com.trans.repository.TransactionRepository;
import com.trans.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImplement implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public List<Long> getByType(String type) {
        List<Transaction> trans = transactionRepository.findByTypeOrderByParentId(type);
        List<Long> longs = new ArrayList<>();
        trans.forEach(x -> longs.add(x.getParentId()));
        return longs;
    }

    @Override
    public Summary sumById(Long id) {
        Summary sum = new Summary();
        List<Transaction> trans = transactionRepository.findByTransId(id);
        if (trans.isEmpty()) {
            Transaction trs = transactionRepository.findByParentId(id);
            if (trs != null) {
                sum.setSum(trs.getAmount());
            } else {
                sum.setSum(0.0);
            }
        } else {
            Double amt = 0.0;
            for (Transaction tran : trans) {
                amt = amt + tran.getAmount();
            }
            sum.setSum(amt);
        }
        return sum;
    }
}
