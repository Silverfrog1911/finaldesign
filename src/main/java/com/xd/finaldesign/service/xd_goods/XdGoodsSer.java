package com.xd.finaldesign.service.xd_goods;

import com.xd.finaldesign.model.XdGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface XdGoodsSer {

    int insertSelective(XdGoods record);

    List<XdGoods> selectAll();

    XdGoods selectGoodByGoodresId(int resid);

}
