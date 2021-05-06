package com.xd.finaldesign.controller;

import com.xd.finaldesign.model.Poly.GoodsInfoAndRes;
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
@RequestMapping("/receipts")
@Api(tags = {""})
public class receiptsController {

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
     * 展示全部收货单
     * @return
     */
    @GetMapping("/selectAll")
    private ResultVO selectAllreceipts(){
        List<GoodsInfoAndRes> goodsInfoAndResList = new ArrayList<GoodsInfoAndRes>();

        for(int i = 0;i<xdReceiptsSer.selectAllReceipts().size();i++){
            GoodsInfoAndRes goodsInfoAndRes = new GoodsInfoAndRes();
            goodsInfoAndRes.setGoodAmount(xdReceiptsSer.selectAllReceipts().get(i).getGoodAmount());
            goodsInfoAndRes.setId((long) Math.toIntExact(xdReceiptsSer.selectAllReceipts().get(i).getId()));
            goodsInfoAndRes.setName(xdGoodsSer.selectGoodByGoodId(xdReceiptsSer.selectAllReceipts().get(i).getGoodId()).getName());
            goodsInfoAndRes.setReceiptsDate(xdReceiptsSer.selectAllReceipts().get(i).getReceiptsDate());
            goodsInfoAndRes.setStatus(xdReceiptsSer.selectAllReceipts().get(i).getStatus());
            goodsInfoAndRes.setUtcCreate(xdReceiptsSer.selectAllReceipts().get(i).getUtcCreate());
            goodsInfoAndRes.setUtcModified(xdReceiptsSer.selectAllReceipts().get(i).getUtcModified());
            goodsInfoAndResList.add(goodsInfoAndRes);
        }

        return ResultUtils.success(goodsInfoAndResList);
    }

    /**
     *展示WORK货物信息
     * @return
     */
    @GetMapping("/selectWORK")
    private ResultVO selectWORK(){
        List<GoodsInfoAndRes> goodsInfoAndResList = new ArrayList<GoodsInfoAndRes>();

        for(int i = 0;i<xdReceiptsSer.selectAllWORK().size();i++){
            GoodsInfoAndRes goodsInfoAndRes = new GoodsInfoAndRes();
            goodsInfoAndRes.setGoodAmount(xdReceiptsSer.selectAllWORK().get(i).getGoodAmount());
            goodsInfoAndRes.setId((long) Math.toIntExact(xdReceiptsSer.selectAllWORK().get(i).getId()));
            goodsInfoAndRes.setName(xdGoodsSer.selectGoodByGoodId(xdReceiptsSer.selectAllWORK().get(i).getGoodId()).getName());
            goodsInfoAndRes.setReceiptsDate(xdReceiptsSer.selectAllWORK().get(i).getReceiptsDate());
            goodsInfoAndRes.setStatus(xdReceiptsSer.selectAllWORK().get(i).getStatus());
            goodsInfoAndRes.setUtcCreate(xdReceiptsSer.selectAllWORK().get(i).getUtcCreate());
            goodsInfoAndRes.setUtcModified(xdReceiptsSer.selectAllWORK().get(i).getUtcModified());
            goodsInfoAndResList.add(goodsInfoAndRes);
        }

        return ResultUtils.success(goodsInfoAndResList);
    }

    /**
     *展示CHECKING货物信息
     * @return
     */
    @GetMapping("/selectCHECKING")
    private ResultVO selectCHECKING(){
        List<GoodsInfoAndRes> goodsInfoAndResList = new ArrayList<GoodsInfoAndRes>();

        for(int i = 0;i<xdReceiptsSer.selectAllCHECKING().size();i++){
            GoodsInfoAndRes goodsInfoAndRes = new GoodsInfoAndRes();
            goodsInfoAndRes.setGoodAmount(xdReceiptsSer.selectAllCHECKING().get(i).getGoodAmount());
            goodsInfoAndRes.setId((long) Math.toIntExact(xdReceiptsSer.selectAllCHECKING().get(i).getId()));
            goodsInfoAndRes.setName(xdGoodsSer.selectGoodByGoodId(xdReceiptsSer.selectAllCHECKING().get(i).getGoodId()).getName());
            goodsInfoAndRes.setReceiptsDate(xdReceiptsSer.selectAllCHECKING().get(i).getReceiptsDate());
            goodsInfoAndRes.setStatus(xdReceiptsSer.selectAllCHECKING().get(i).getStatus());
            goodsInfoAndRes.setUtcCreate(xdReceiptsSer.selectAllCHECKING().get(i).getUtcCreate());
            goodsInfoAndRes.setUtcModified(xdReceiptsSer.selectAllCHECKING().get(i).getUtcModified());
            goodsInfoAndResList.add(goodsInfoAndRes);
        }

        return ResultUtils.success(goodsInfoAndResList);
    }

    /**
     *展示RECEIVED货物信息
     * @return
     */
    @GetMapping("/selectRECEIVED")
    private ResultVO selectRECEIVED(){
        List<GoodsInfoAndRes> goodsInfoAndResList = new ArrayList<GoodsInfoAndRes>();

        for(int i = 0;i<xdReceiptsSer.selectAllGRECEVIED().size();i++){
            GoodsInfoAndRes goodsInfoAndRes = new GoodsInfoAndRes();
            goodsInfoAndRes.setGoodAmount(xdReceiptsSer.selectAllGRECEVIED().get(i).getGoodAmount());
            goodsInfoAndRes.setId((long) Math.toIntExact(xdReceiptsSer.selectAllGRECEVIED().get(i).getId()));
            goodsInfoAndRes.setName(xdGoodsSer.selectGoodByGoodId(xdReceiptsSer.selectAllGRECEVIED().get(i).getGoodId()).getName());
            goodsInfoAndRes.setReceiptsDate(xdReceiptsSer.selectAllGRECEVIED().get(i).getReceiptsDate());
            goodsInfoAndRes.setStatus(xdReceiptsSer.selectAllGRECEVIED().get(i).getStatus());
            goodsInfoAndRes.setUtcCreate(xdReceiptsSer.selectAllGRECEVIED().get(i).getUtcCreate());
            goodsInfoAndRes.setUtcModified(xdReceiptsSer.selectAllGRECEVIED().get(i).getUtcModified());
            goodsInfoAndResList.add(goodsInfoAndRes);
        }

        return ResultUtils.success(goodsInfoAndResList);
    }

    /**
     * 验货
     * 收货验货=更新数据库中收货单表中收货单的状态为Checking
     * @param
     * @return
     */
    @PostMapping("/updateCheckingByGoodResId")
    private ResultVO updateCheckingByGoodId(int Id){
        xdReceiptsSer.updateCheckingByGoodResId(Id);
        return ResultUtils.success("update success!");
    }

}
