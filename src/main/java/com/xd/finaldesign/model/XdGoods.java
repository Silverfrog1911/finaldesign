package com.xd.finaldesign.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * xd_goods
 * @author 
 */
@Data
@Repository
public class XdGoods implements Serializable {
    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品数量
     */
    private Integer amount;

    /**
     * 进货单id
     */
    private Long receiptId;

    /**
     * 所在商店id
     */
    private Long storeId;

    /**
     * 进货日期
     */
    private Date receiptsDate;

    private Date utcCreate;

    private Date utcModified;

    private static final long serialVersionUID = 1L;
}