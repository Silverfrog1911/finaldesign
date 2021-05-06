package com.xd.finaldesign.mapper;

import com.xd.finaldesign.model.XdReceipts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XdReceiptsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(XdReceipts record);

    int insertSelective(XdReceipts record);

    XdReceipts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XdReceipts record);

    int updateByPrimaryKey(XdReceipts record);

    List<XdReceipts> selectAllReceipts();

    void updateStatusByGoodReceiptsId(Long id);

    void updateStatusByGoodsId(int id);

    List<XdReceipts> selectAllWORK();

    List<XdReceipts> selectAllCHECKING();

    List<XdReceipts> selectAllGRECEVIED();

    XdReceipts selectResByGoodId(int goodId);

    void updateCheckingByGoodId(@Param("goodId") int goodId);

    void updateReceivedByGoodId(@Param("goodId") int goodId);

    void updateStatus(XdReceipts xdReceipts);

    void updateCheckingByGoodResId(int id);

    void deletGoodBygoodId(int goodId);

}