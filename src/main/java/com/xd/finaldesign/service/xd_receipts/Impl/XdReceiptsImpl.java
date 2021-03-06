package com.xd.finaldesign.service.xd_receipts.Impl;

import com.xd.finaldesign.mapper.XdGoodsDao;
import com.xd.finaldesign.mapper.XdGoodsPosDao;
import com.xd.finaldesign.mapper.XdReceiptsDao;
import com.xd.finaldesign.model.XdReceipts;
import com.xd.finaldesign.service.xd_receipts.XdReceiptsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XdReceiptsImpl implements XdReceiptsSer {

    @Autowired
    private XdGoodsDao xdGoodsDao;

    @Autowired
    private XdGoodsPosDao xdGoodsPosDao;

    @Autowired
    private XdReceiptsDao xdReceiptsDao;

    @Override
    public XdReceipts selectByPrimaryKey(Integer id) {
        return xdReceiptsDao.selectByPrimaryKey(id);
    }

    /**
     * 查询某全部收货单
     * @return
     */
    @Override
    public List<XdReceipts> selectAllReceipts() {
        return xdReceiptsDao.selectAllReceipts();
    }

    /**
     * 插入数据库中收货单表新的一条数据
     * @param record
     * @return
     */
    @Override
    public int insert(XdReceipts record) {
        return xdReceiptsDao.insertSelective(record);
    }

    @Override
    public void updateStatusByGoodReceiptsId(Long id) {
        xdReceiptsDao.updateStatusByGoodReceiptsId(id);
    }

    @Override
    public List<XdReceipts> selectAllWORK() {
        return xdReceiptsDao.selectAllWORK();
    }

    @Override
    public List<XdReceipts> selectAllCHECKING() {
        return xdReceiptsDao.selectAllCHECKING();
    }

    @Override
    public List<XdReceipts> selectAllGRECEVIED() {
        return xdReceiptsDao.selectAllGRECEVIED();
    }

    @Override
    public XdReceipts selectResByGoodId(int good_id) {
        return xdReceiptsDao.selectResByGoodId(good_id);
    }

    @Override
    public void updateCheckingByGoodId(int good_id) {
        xdReceiptsDao.updateCheckingByGoodId(good_id);
    }

    @Override
    public void updateReceivedByGoodId(int good_id) {
        System.out.println(good_id);
        xdReceiptsDao.updateReceivedByGoodId(good_id);
        System.out.println("SER");
    }

    @Override
    public void updateStatus(XdReceipts xdReceipts) {
        xdReceiptsDao.updateStatus(xdReceipts);
    }

    @Override
    public void updateCheckingByGoodResId(int id) {
        xdReceiptsDao.updateCheckingByGoodResId(id);
    }

    @Override
    public void deletGoodBygoodId(int good_id) {
        xdReceiptsDao.deletGoodBygoodId(good_id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        xdReceiptsDao.deleteByPrimaryKey(id);
        return 0;
    }


}
