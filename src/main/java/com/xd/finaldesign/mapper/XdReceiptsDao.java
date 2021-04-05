package com.xd.finaldesign.mapper;

import com.xd.finaldesign.model.XdReceipts;

public interface XdReceiptsDao {
    int deleteByPrimaryKey(Long id);

    int insert(XdReceipts record);

    int insertSelective(XdReceipts record);

    XdReceipts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(XdReceipts record);

    int updateByPrimaryKey(XdReceipts record);
}