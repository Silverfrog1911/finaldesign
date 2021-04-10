package com.xd.finaldesign.mapper;

import com.xd.finaldesign.model.XdReceipts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface XdReceiptsDao {
    int deleteByPrimaryKey(Long id);

    int insert(XdReceipts record);

    int insertSelective(XdReceipts record);

    XdReceipts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(XdReceipts record);

    int updateByPrimaryKey(XdReceipts record);

    List<XdReceipts> selectAllReceipts();
}