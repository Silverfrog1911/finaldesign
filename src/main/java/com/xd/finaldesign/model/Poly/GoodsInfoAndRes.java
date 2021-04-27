package com.xd.finaldesign.model.Poly;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
@Data
@Repository
public class GoodsInfoAndRes {

    /**
     * 进货单id
     */
    private Long id;

    /**
     * 此单进货数量
     */
    private Integer goodAmount;

    /**
     * 此进货单创建日期
     */
    private Date receiptsDate;

    /**
     * 进货状态
     */
    private String status;

    /**
     * 商品名
     */
    private String name;

    private Date utcCreate;

    private Date utcModified;

    private static final long serialVersionUID = 1L;
}

