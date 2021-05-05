package com.xd.finaldesign.service.xd_goods_pos;

import com.xd.finaldesign.model.XdGoodsPos;

import java.util.List;

public interface XdGoodsPosSer {

    void insertSelective(XdGoodsPos record);

    List<XdGoodsPos> selectAll();

    List<XdGoodsPos> selectByGoodId(int good_id);

    void UpdateGoodsByGoodId(int good_id,int capacity);

    int selectGoodPosIdByGoodIdAndGoodCap(int good_id,int capacity);

    int deleteByPrimaryKey(Long goodsPosId);

    void updatePosInfos(int goods_pos_id,int capacity);

    void deleteByGoodId(int good_id);


}
