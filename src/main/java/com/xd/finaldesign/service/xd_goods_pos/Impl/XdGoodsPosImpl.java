package com.xd.finaldesign.service.xd_goods_pos.Impl;

import com.xd.finaldesign.mapper.XdGoodsDao;
import com.xd.finaldesign.mapper.XdGoodsPosDao;
import com.xd.finaldesign.mapper.XdReceiptsDao;
import com.xd.finaldesign.model.XdGoodsPos;
import com.xd.finaldesign.service.xd_goods_pos.XdGoodsPosSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XdGoodsPosImpl implements XdGoodsPosSer {

    @Autowired
    private XdGoodsDao xdGoodsDao;

    @Autowired
    private XdGoodsPosDao xdGoodsPosDao;

    @Autowired
    private XdReceiptsDao xdReceiptsDao;

    /**
     * 插入一条货物存放位置信息
     * @param record
     */
    @Override
    public void insertSelective(XdGoodsPos record) {
        xdGoodsPosDao.insertSelective(record);
    }

    /**
     * 查询全部货物存放位置信息
     * @return
     */
    @Override
    public List<XdGoodsPos> selectAll() {
        return xdGoodsPosDao.selectAll();
    }

    /**
     * 根据 good_id 查询此货物存放的数量，位置等信息
     * @param good_id
     * @return
     */
    @Override
    public List<XdGoodsPos> selectByGoodId(int good_id) {
        return xdGoodsPosDao.selectByGoodId(good_id);
    }

    /**
     * 根据 good_id 更新此货物再某一个货架上的容量
     * @param good_id
     * @param capacity
     */
    @Override
    public void UpdateGoodsByGoodId(int good_id, int capacity) {
        xdGoodsPosDao.UpdateGoodsByGoodId(good_id,capacity);
    }

    /**
     * 根据 good_id 且 此货物再某一个货架上货物量为0，并返回查询所得的good_Pos_Id
     * @param good_id
     * @param capacity
     * @return
     */
    @Override
    public int selectGoodPosIdByGoodIdAndGoodCap(int good_id, int capacity) {
        return xdGoodsPosDao.selectGoodPosIdByGoodIdAndGoodCap(good_id,capacity);
    }

    @Override
    public int deleteByPrimaryKey(Long goodsPosId) {
        return xdGoodsPosDao.deleteByPrimaryKey(goodsPosId);
    }


}
