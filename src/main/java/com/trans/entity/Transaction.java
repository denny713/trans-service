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
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "trans_id")
    private Long transId;

    @Column(name = "type", length = 25)
    private String type;

    @Column(name = "amount")
    private Double amount;
}
