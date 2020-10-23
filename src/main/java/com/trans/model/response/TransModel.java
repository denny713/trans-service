package com.trans.model.response;

import lombok.Data;

@Data
public class TransModel {

    private Long parentId;
    private String type;
    private Double amount;
}
