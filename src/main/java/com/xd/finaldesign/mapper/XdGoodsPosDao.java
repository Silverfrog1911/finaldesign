package com.xd.finaldesign.mapper;

import com.xd.finaldesign.model.XdGoodsPos;

public interface XdGoodsPosDao {
    int deleteByPrimaryKey(Long goodsPosId);

    int insert(XdGoodsPos record);

    int insertSelective(XdGoodsPos record);

    XdGoodsPos selectByPrimaryKey(Long goodsPosId);

    int updateByPrimaryKeySelective(XdGoodsPos record);

    int updateByPrimaryKey(XdGoodsPos record);
}