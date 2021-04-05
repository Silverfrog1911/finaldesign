package com.xd.finaldesign.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * xd_goods_pos
 * @author 
 */
@Data
@Repository
public class XdGoodsPos implements Serializable {
    /**
     * 货架id
     */
    private Long goodsPosId;

    /**
     * 商品id
     */
    private Long goodId;

    /**
     * 货架容量
     */
    private Integer capacity;

    private Date utcCreate;

    private Date utcModified;

    private static final long serialVersionUID = 1L;
}