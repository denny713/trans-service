package com.trans.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "trans_service")
public class Transaction {

    @Id
    @Column(name = "transaction_id", length = 15)
    private String transId;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "type", length = 25)
    private String type;

    @Column(name = "amount")
    private Double amount;
}
