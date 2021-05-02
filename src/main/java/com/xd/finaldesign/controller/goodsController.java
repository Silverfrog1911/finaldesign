package com.xd.finaldesign.controller;

import com.xd.finaldesign.model.XdGoods;
import com.xd.finaldesign.model.XdReceipts;
import com.xd.finaldesign.service.xd_goods.XdGoodsSer;
import com.xd.finaldesign.service.xd_goods_pos.XdGoodsPosSer;
import com.xd.finaldesign.service.xd_receipts.XdReceiptsSer;
import com.xd.finaldesign.util.ResultUtils;
import com.xd.finaldesign.util.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@Api(tags = {""})
public class goodsController {

    /**
     * 收货授权=插入数据库中收货单表新的一条数据（status=work），插入数据库中货物表一条数据（此次进货的商品的基本信息）
     * 收货验货=更新数据库中收货单表中收货单的状态为Checking
     * 收货确认=更新数据库中收货单表中收货单的状态为Received，
     *         首先查询货位表中是否存在同类商品，若存在则放置到已存在位置，
     *         若不存在，分配新的位置，插入货位表一条新数据
     * 货位更新=更新数据库中货位表中货物在某一位置的数量或位置
     */

    @Autowired
    private XdReceiptsSer xdReceiptsSer;

    @Autowired
    private XdGoodsSer xdGoodsSer;

    @Autowired
    private XdGoodsPosSer xdGoodsPosSer;


    /**
     *展示全部货物信息
     * @return
     */
    @GetMapping("/selectAll")
    private ResultVO selectAllGoods(){
        return ResultUtils.success(xdGoodsSer.selectAll());
    }


    /**
     * 收货授权=插入数据库中收货单表新的一条数据（status=WORK）
     */
    @PostMapping("insertWORK")
    private ResultVO insertWORK(XdGoods xdGoods){

        xdGoodsSer.insertSelective(xdGoods);//插入基本的货物信息
        //Math.toIntExact()
        XdReceipts xdReceipts = new XdReceipts();
        xdReceipts.setGoodId(Math.toIntExact(xdGoodsSer.selectGoodByGoodresName(xdGoods.getName()).getId()));
        xdReceipts.setStatus("WORK");
        xdReceipts.setGoodAmount(xdGoods.getAmount());

        xdReceiptsSer.insert(xdReceipts);//插入收货单表一条信息

        return ResultUtils.success("Insert Success !");
    }


}
