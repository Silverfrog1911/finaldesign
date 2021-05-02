package com.xd.finaldesign.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * xd_receipts
 * @author 
 */
@Data
@Repository
public class XdReceipts implements Serializable {
    /**
     * 进货单id
     */
    private Integer id;

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

    private Date utcCreate;

    private Date utcModified;

    private Integer goodId;

    private static final long serialVersionUID = 1L;
}