package com.xd.finaldesign.controller;

import com.xd.finaldesign.service.xd_receipts.XdReceiptsSer;
import com.xd.finaldesign.util.ResultUtils;
import com.xd.finaldesign.util.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receipts")
@Api(tags = {""})
public class receiptsController {

    @Autowired
    private XdReceiptsSer xdReceiptsSer;

    @GetMapping("/selectAll")
    private ResultVO selectAllreceipts(){
        return ResultUtils.success(xdReceiptsSer.selectAllReceipts()); }

}
