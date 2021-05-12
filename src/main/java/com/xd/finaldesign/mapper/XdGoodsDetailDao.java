package com.xd.finaldesign.mapper;

import com.xd.finaldesign.model.XdGoodsDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface XdGoodsDetailDao {


    @Insert("insert into xd_goods_detail values(null,#{goodsId},#{shouldAmount},#{receiver})")
    int insert(XdGoodsDetail xdGoodsDetail);

    @Select("select id,goods_id as goodsId, should_amount as shouldAmount,receiver from xd_goods_detail where goods_id=#{gid}")
    XdGoodsDetail selectByGid(int gid);
}
