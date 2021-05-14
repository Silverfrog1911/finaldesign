package com.xd.finaldesign.controller;

import com.xd.finaldesign.enums.PosCapEnum;
import com.xd.finaldesign.model.Poly.GoodsInfoAndPos;
import com.xd.finaldesign.model.Poly.GoodsInfoAndRes;
import com.xd.finaldesign.model.XdGoodsPos;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/goodsPos")
@Api(tags = {""})
public class goodsPosController {

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

    PosCapEnum posCapEnum = PosCapEnum.CAPACITY;
    int shelfCap = posCapEnum.getShelfcapacity();

    @GetMapping("/selectAll")
    private ResultVO selectAll(){

        List<GoodsInfoAndPos> goodsInfoAndPosList =new ArrayList<GoodsInfoAndPos>();
        for(int i = 0;i<xdGoodsPosSer.selectAll().size();i++){
            GoodsInfoAndPos goodsInfoAndPos = new GoodsInfoAndPos();
            goodsInfoAndPos.setGoodsPosId(xdGoodsPosSer.selectAll().get(i).getGoodsPosId());
            goodsInfoAndPos.setName(xdGoodsSer.selectGoodByGoodId((int) Math.toIntExact(xdGoodsPosSer.selectAll().get(i).getGoodId())).getName());
            goodsInfoAndPos.setGoodId(xdGoodsPosSer.selectAll().get(i).getGoodId());
            goodsInfoAndPos.setCapacity(xdGoodsPosSer.selectAll().get(i).getCapacity());
            goodsInfoAndPosList.add(goodsInfoAndPos);
        }
        return ResultUtils.success(goodsInfoAndPosList);
    }

    /**
     * 货位更新=更新数据库中货位表中货物在某一位置的数量
     * @param goodPosId
     * @param capacity
     * @return
     */
    @PostMapping("/updatePosInfos")
    private ResultVO updatePosInfos(int goodPosId,int capacity){
        xdGoodsPosSer.updatePosInfos(goodPosId,shelfCap-capacity);

        if(capacity == 20 && (shelfCap-capacity) == 0){
            xdGoodsPosSer.deleteByPrimaryKey((long) goodPosId);
        }
        if(capacity > 20){
            return ResultUtils.success("Error !");
        }
        return ResultUtils.success("update success!");
    }

    /**
     * 收货确认=更新数据库中收货单表中收货单的状态为Received，
     *         首先查询货位表中是否存在同类商品，
     *         若存在则放置到已存在位置，
     *         若不存在，分配新的位置，插入货位表一条新数据
     * @param name
     * @param capacity
     * @return
     */
    @PostMapping("/Confirm")
    private ResultVO Confim(String name,int capacity){

        int shelfNeed = 0;//所需要的货架数

        int goodId = Math.toIntExact(xdGoodsSer.selectGoodByGoodresName(name).getId());

        xdReceiptsSer.updateReceivedByGoodId(goodId);

        if((capacity/shelfCap)==0){//货量小于20
            shelfNeed = 1;

            if((capacity%shelfCap)==0){
                return ResultUtils.success("Confirm Fail ! NO GOODS ! ");
            }
            if((capacity%shelfCap)!=0){
                XdGoodsPos xdGoodsPos = new XdGoodsPos();
                xdGoodsPos.setGoodId((long) goodId);
                xdGoodsPos.setCapacity(capacity);
                xdGoodsPosSer.insertSelective(xdGoodsPos);
            }
        }
        if((capacity/shelfCap)!=0){//货量大于20
            shelfNeed = capacity/20;

            if((capacity%shelfCap)==0){
                for(int i = 0;i < shelfNeed;i++){
                    XdGoodsPos xdGoodsPos = new XdGoodsPos();
                    xdGoodsPos.setGoodId((long) goodId);
                    xdGoodsPosSer.insertSelective(xdGoodsPos);
                }
            }
            if((capacity%shelfCap)!=0){
                shelfNeed = shelfNeed + 1;
                for(int i = 0;i < shelfNeed;i++){
                    XdGoodsPos xdGoodsPos = new XdGoodsPos();
                    xdGoodsPos.setGoodId((long) goodId);
                    xdGoodsPosSer.insertSelective(xdGoodsPos);
                }
                XdGoodsPos xdGoodsPos = new XdGoodsPos();
                xdGoodsPos.setGoodId((long) goodId);
                xdGoodsPos.setCapacity(capacity%20);
                xdGoodsPosSer.insertSelective(xdGoodsPos);
            }
        }



        return ResultUtils.success("Confirm Success !");
    }


}
