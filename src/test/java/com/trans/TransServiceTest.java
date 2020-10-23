package com.trans;

import com.trans.controller.TransactionController;
import com.trans.model.Status;
import com.trans.model.Summary;
import com.trans.model.TransModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TransServiceTest {

    @Autowired
    private TransactionController transactionController;

    private static TransactionController transController = new TransactionController();

    @BeforeAll
    public static void setData() {
        TransModel trans = new TransModel();
        trans.setType("cars");
        trans.setAmount(60000.0);
        Status status = transController.saveTrans(trans, "10");
        System.out.println("Save " + status.getStatus());
    }

    @Test
    public void saveTransactionTest() {
        TransModel trans = new TransModel();
        trans.setParentId(11L);
        trans.setType("shopping");
        trans.setAmount(30000.0);
        Status status = transactionController.saveTrans(trans, "10");
        Assertions.assertEquals("Ok", status.getStatus());
    }

    @Test
    public void getByTypeTest() {
        List<Long> longs = transactionController.getByType("cars");
        Assertions.assertEquals(1, longs.size());
    }

    @Test
    public void getSumTest() {
        Summary sum = transactionController.summaryById("10");
        Assertions.assertEquals(60000.0, sum.getSum());
    }
}
