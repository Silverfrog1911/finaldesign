package com.xd.finaldesign.model.Poly;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class GoodsInfoAndPos {


    /**
     * 货架id
     */
    private Long goodsPosId;

    /**
     * 商品id
     */
    private Long goodId;

    /**
     * 商品名
     */
    private String name;

    /**
     * 货架容量
     */
    private Integer capacity;

    private static final long serialVersionUID = 1L;

}
