package com.lbyier.collectionInfo.controller;

import com.lbyier.collectionInfo.service.CollectionInfoService;
import com.lbyier.equipment.model.Equipment;
import com.util.ErrorCode;
import com.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LByier
 * @date 2020/11/7 10:55
 */
@RestController
@RequestMapping("/collection")
public class CollectionInfoCtroller {
    @Autowired
    private CollectionInfoService collectionInfoService;

    @PostMapping("/updateInfo")
    public  @ResponseBody ResponseVo updateInfo(){
        ResponseVo responseVo = new ResponseVo();

        try {
            responseVo=collectionInfoService.updateInfo();
            System.out.println("处理器：温湿度传感器数据=> "+responseVo.getData());
        } catch (Exception e) {
            //异常处理 提示前台 服务端有异常
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setSuccess(false);
            responseVo.setMsg("系统异常");
            //服务端后台打印异常
            e.printStackTrace();
        }

        return responseVo;
    }
}
