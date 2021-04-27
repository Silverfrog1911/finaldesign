package com.xd.finaldesign.service.xd_goods.Impl;

import com.xd.finaldesign.mapper.XdGoodsDao;
import com.xd.finaldesign.mapper.XdGoodsPosDao;
import com.xd.finaldesign.mapper.XdReceiptsDao;
import com.xd.finaldesign.model.Poly.GoodsInfoAndRes;
import com.xd.finaldesign.model.XdGoods;
import com.xd.finaldesign.service.xd_goods.XdGoodsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XdGoodsImpl implements XdGoodsSer {

    @Autowired
    private XdGoodsDao xdGoodsDao;

    @Autowired
    private XdGoodsPosDao xdGoodsPosDao;

    @Autowired
    private XdReceiptsDao xdReceiptsDao;

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

    /**
     * 根据收货表id查询货物信息
     * @param resid
     * @return
     */
    @Override
    public XdGoods selectGoodByGoodresId(int resid) {
        return xdGoodsDao.selectGoodByGoodResId(resid);
    }


}
