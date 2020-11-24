
package com.lbyier.equipment.controller;

import com.lbyier.equipment.model.Equipment;
import com.lbyier.equipment.service.EquipmentService;
import com.util.ErrorCode;
import com.util.ResponseVo;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
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
    private static Logger logger=Logger.getLogger(EquipmentController.class);
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping("/addEquipment")
    public  @ResponseBody ResponseVo addEquipment( @RequestBody Equipment equipment){
        ResponseVo responseVo = new ResponseVo();

        try {
            System.out.println("添加的设备信息："+equipment);
            responseVo=equipmentService.addEquipment(equipment);
            System.out.println("处理器：添加设备结果=> "+responseVo.getMsg());
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

    @PostMapping("/selectAllEquipment")
    public   @ResponseBody ResponseVo selectAllEquipment(@RequestBody Equipment equipment){
        ResponseVo responseVo = new ResponseVo();

        try {

            responseVo=equipmentService.selectAllEquipment(equipment);
            logger.info("处理器：请求参数："+equipment.getEquipment_type());
            logger.info("处理器：查询设备结果=>"+responseVo.getMsg());
            logger.info("处理器：查询设备=>"+responseVo.getData());
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

    @PostMapping("/findEquipmentType")
    public  @ResponseBody ResponseVo findEquipmentType(){
        /*
         *methodName: findEquipmentType
         * @Description: 查询设备类型
           * @param
         * @return com.util.ResponseVo
         * @author: bier
         * @date 2020/11/9 23:07
         *
         */
        ResponseVo responseVo = new ResponseVo();

        try {

            responseVo=equipmentService.findEquipmentType();
            System.out.println("处理器：查询设备的类型结果=> "+responseVo.getMsg());
            System.out.println("处理器：设备类型=> "+responseVo.getData());
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

    @PostMapping("/delEquipment")
    public  @ResponseBody ResponseVo delEquipment(@RequestBody Equipment equipment){

        ResponseVo responseVo = new ResponseVo();

        try {

            responseVo=equipmentService.delEquipment(equipment);
            System.out.println("处理器：删除的设备id参数=> "+equipment);

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

    @PostMapping("/searchEquipment")
    public  @ResponseBody ResponseVo searchEquipment(@RequestBody String equipment_type){
        ResponseVo responseVo = new ResponseVo();

        try {

            responseVo=equipmentService.searchEquipment(equipment_type);
            System.out.println("处理器：类型查找参数=> "+equipment_type);
            System.out.println("处理器：查询设备=> "+responseVo.getData());
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
