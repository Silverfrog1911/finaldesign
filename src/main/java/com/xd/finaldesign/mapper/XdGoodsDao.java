package com.xd.finaldesign.mapper;

import com.xd.finaldesign.model.XdGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XdGoodsDao {
    int deleteByPrimaryKey(Long id);

    int insert(XdGoods record);

    int insertSelective(XdGoods record);

    XdGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(XdGoods record);

    int updateByPrimaryKey(XdGoods record);

    List<XdGoods> selectAll();

    XdGoods selectGoodByGoodResId(int resid);

    XdGoods selectGoodByGoodresName(String name);

    XdGoods selectGoodByGoodId(int good_id);



}