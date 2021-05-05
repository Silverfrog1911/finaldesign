package com.xd.finaldesign.mapper;

import com.xd.finaldesign.model.XdGoodsPos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XdGoodsPosDao {
    int deleteByPrimaryKey(Long goodsPosId);

    int insert(XdGoodsPos record);

    int insertSelective(XdGoodsPos record);

    XdGoodsPos selectByPrimaryKey(Long goodsPosId);

    int updateByPrimaryKeySelective(XdGoodsPos record);

    int updateByPrimaryKey(XdGoodsPos record);

    List<XdGoodsPos> selectAll();

    List<XdGoodsPos> selectByGoodId(int good_id);

    void UpdateGoodsByGoodId(int good_id,int capacity);

    int selectGoodPosIdByGoodIdAndGoodCap(int good_id,int capacity);

    void updatePosInfos(int goods_pos_id,int capacity);

    void deleteByGoodId(int good_id);

}