
package com.lbyier.equipment.controller;

import com.lbyier.equipment.model.Equipment;
import com.lbyier.equipment.service.EquipmentService;
import com.util.ErrorCode;
import com.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author LByier
 * @date 2020/10/26 20:47
 */

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping("/addEquipment")
    public  @ResponseBody ResponseVo addEquipment( Equipment equipment){
        ResponseVo responseVo = new ResponseVo();

        try {
            System.out.println("sbxx"+equipment);
            responseVo=equipmentService.addEquipment(equipment);
            System.out.println("处理器：添加设备结果"+responseVo.getData());
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
