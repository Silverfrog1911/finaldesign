package com.xd.finaldesign.service.xd_receipts;

import com.xd.finaldesign.model.XdReceipts;

import java.util.List;

public interface XdReceiptsSer {

    XdReceipts selectByPrimaryKey(Integer id);

    List<XdReceipts> selectAllReceipts();

    int insert(XdReceipts record);

    void updateStatusByGoodReceiptsId(Long id);

    List<XdReceipts> selectAllWORK();

    List<XdReceipts> selectAllCHECKING();

    List<XdReceipts> selectAllGRECEVIED();

    XdReceipts selectResByGoodId(int good_id);

    void updateCheckingByGoodId(int good_id);

    void updateReceivedByGoodId(int good_id);

    void updateStatus(XdReceipts xdReceipts);

    void updateCheckingByGoodResId(int id);

    void deletGoodBygoodId(int good_id);

    int deleteByPrimaryKey(Integer id);
}
