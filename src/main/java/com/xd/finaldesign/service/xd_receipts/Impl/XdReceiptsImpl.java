package com.xd.finaldesign.service.xd_receipts.Impl;

import com.xd.finaldesign.mapper.XdGoodsDao;
import com.xd.finaldesign.service.xd_receipts.XdReceiptsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xd.finaldesign.model.*;

@Service
public class XdReceiptsImpl implements XdReceiptsSer {

    @Autowired
    private XdGoodsDao xdGoodsDao;

}
