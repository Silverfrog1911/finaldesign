package com.xd.finaldesign.service.xd_receipts;

import com.xd.finaldesign.model.XdReceipts;

import java.util.List;

public interface XdReceiptsSer {

    /**
     * 查询某全部收货单
     * @return
     */
    List<XdReceipts> selectAllReceipts();

}
