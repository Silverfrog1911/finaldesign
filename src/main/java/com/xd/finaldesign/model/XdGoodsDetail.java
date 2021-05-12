package com.xd.finaldesign.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class XdGoodsDetail {

    private Integer id;
    private Integer goodsId;
    private Integer shouldAmount;
    private String receiver;
    private static final long serialVersionUID = 1L;
}
