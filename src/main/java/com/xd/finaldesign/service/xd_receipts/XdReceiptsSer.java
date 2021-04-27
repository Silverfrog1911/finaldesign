package com.xd.finaldesign.service.xd_receipts;

import com.xd.finaldesign.model.XdReceipts;

import java.util.List;

public interface XdReceiptsSer {


    List<XdReceipts> selectAllReceipts();

    int insert(XdReceipts record);

    void updateStatusByGoodReceiptsId(Long id);

    List<XdReceipts> selectAllWORK();

    List<XdReceipts> selectAllCHECKING();

    List<XdReceipts> selectAllGRECEVIED();

}
