package com.xd.finaldesign.service.xd_goods.Impl;

import com.xd.finaldesign.mapper.XdGoodsDao;
import com.xd.finaldesign.mapper.XdGoodsPosDao;
import com.xd.finaldesign.mapper.XdReceiptsDao;
import com.xd.finaldesign.model.XdGoods;
import com.xd.finaldesign.service.xd_goods.XdGoodsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XdGoodsImpl implements XdGoodsSer {

    @Autowired
    private XdGoodsDao xdGoodsDao;

    @Autowired
    private XdGoodsPosDao xdGoodsPosDao;

    @Autowired
    private XdReceiptsDao xdReceiptsDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        xdGoodsDao.deleteByPrimaryKey(id);
        return 0;
    }

    /**
     * 插入一条货物信息
     * @param record
     * @return
     */
    @Override
    public int insertSelective(XdGoods record) {
        return xdGoodsDao.insertSelective(record);
    }

    /**
     * 查询全部货物信息
     * @return
     */
    @Override
    public List<XdGoods> selectAll() {
        return xdGoodsDao.selectAll();
    }

    @Override
    public XdGoods selectGoodByGoodId(int good_id) {
        return xdGoodsDao.selectGoodByGoodId(good_id);
    }

    /**
     * 根据收货表id查询货物信息
     * @param resid
     * @return
     */
    @Override
    public XdGoods selectGoodByGoodresId(int resid) {
        return xdGoodsDao.selectGoodByGoodResId(resid);
    }

    @Override
    public XdGoods selectGoodByGoodresName(String name) {
        return xdGoodsDao.selectGoodByGoodresName(name);
    }

    @Override
    public void updateStoreIdByGId(int good_id, int storeId) {
        xdGoodsDao.updateStoreIdByGId(good_id,storeId);
    }

    @Override
    public void updateResIdByGId(int id, int receipt_id) {
        xdGoodsDao.updateResIdByGId(id,receipt_id);
    }


}
