package com.xd.finaldesign.service.xd_goods;

import com.xd.finaldesign.model.XdGoods;
import com.xd.finaldesign.model.XdGoodsDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface XdGoodsSer {

    int deleteByPrimaryKey(Long id);

    int insertSelective(XdGoods record);

    List<XdGoods> selectAll();

    XdGoods selectGoodByGoodId(int good_id);

    XdGoods selectGoodByGoodresId(int resid);
    XdGoods selectGoodByGoodresName(String name);

    void updateStoreIdByGId(int good_id,int storeId);

    void updateResIdByGId(int id,int receipt_id);

    int insertDetail(XdGoodsDetail xdGoodsDetail);

    XdGoodsDetail selectDetail(int good_id);

}
