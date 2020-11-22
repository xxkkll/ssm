package com.lbyier.equipment.service.impl;

import com.lbyier.equipment.dao.EquipmentDao;
import com.lbyier.equipment.model.Equipment;
import com.lbyier.equipment.service.EquipmentService;
import com.util.ErrorCode;
import com.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author LByier
 * @date 2020/10/26 16:32
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;




        @Override
        public ResponseVo addEquipment(Equipment equipment) {
            /*
             *methodName: addEquipment
             * @Description: 添加设备
               * @param equipment
             * @return com.util.ResponseVo
             * @author: bier
             * @date 2020/11/4 11:54
             *
             */
            ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "添加设备失败，请重试...");
            //验证数据是否为空
                if (StringUtils.isEmpty(equipment.getEquipment_name())){
                        responseVo.setMsg("设备名不能为空");
                        return responseVo;
                }
                if (StringUtils.isEmpty(equipment.getEquipment_type())){
                        responseVo.setMsg("设备类型不能为空");
                        return responseVo;
                }
                if (StringUtils.isEmpty(equipment.getOwner_id())){
                        responseVo.setMsg("用户手机号不能为空");
                        return responseVo;
                }
            System.out.println("业务逻辑收到的设备信息："+equipment);
                //查询是否有重名设备
                Equipment obj=equipmentDao.selectEquipment(equipment.getEquipment_name(),equipment.getEquipment_type(),equipment.getEquipment_id());
                if(obj!=null){
                    responseVo.setMsg("设备已存在 请重新输入设备名！");
                    responseVo.setData(obj);
                    return responseVo;
                }
                //新增设备
                Integer result=equipmentDao.addEquipment(equipment);
                if (result!=null){
                    responseVo.setMsg("新增设备成功");
                    responseVo.setCode(ErrorCode.SUCCESS);
                    responseVo.setSuccess(true);

                }

                return responseVo;

        }

    @Override
    public ResponseVo selectAllEquipment(String equipment_type) {
        /*
         *methodName: selectAllEquipment
         * @Description: 查询所有设备信息
           * @param
         * @return com.util.ResponseVo
         * @author: bier
         * @date 2020/11/5 16:12
         *
         */
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "无设备信息，请重试...");
        List<Equipment> equipment=equipmentDao.selectAllEquipment(equipment_type);
        if(equipment!=null){
            responseVo.setData(equipment);
            responseVo.setSuccess(true);
            responseVo.setCode(ErrorCode.SUCCESS);
            responseVo.setMsg("查询成功");
            return responseVo;
        }
        return responseVo;
    }

    @Override
    public ResponseVo findEquipmentType() {
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "无设备类型信息，请重试...");
        List<Equipment> types=equipmentDao.findEquipmentType();
        if(types!=null){
            responseVo.setData(types);
            responseVo.setSuccess(true);
            responseVo.setCode(ErrorCode.SUCCESS);
            responseVo.setMsg("查询成功");
            return responseVo;
        }
        return responseVo;


    }

    @Override
    public ResponseVo delEquipment(Equipment equipment) {
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "删除失败，请重试...");
        //验证传入参数是否为空
        if (StringUtils.isEmpty(equipment.getEquipment_id())){
            responseVo.setMsg("从页面获取的设备id为空 不予执行删除");
            return responseVo;
        }
        if (StringUtils.isEmpty(equipment.getEquipment_name())){
            responseVo.setMsg("从页面获取的设备名称为空 不予执行删除");
            return responseVo;
        }
        if (StringUtils.isEmpty(equipment.getEquipment_type())){
            responseVo.setMsg("从页面获取的设备类型为空 不予执行删除");
            return responseVo;
        }
        String equipment_type=equipment.getEquipment_type();
        String equipment_name=equipment.getEquipment_name();
        String equipment_id=equipment.getEquipment_id();
        //执行逻辑删除
        int result=equipmentDao.delEquipment(equipment_type,equipment_name,equipment_id);
        if(result==1){
            responseVo.setSuccess(true);
            responseVo.setCode(ErrorCode.SUCCESS);
            responseVo.setMsg("删除设备成功");
            return responseVo;
        }
        return responseVo;
    }

    @Override
    public ResponseVo searchEquipment(String equipment_type) {
            /*
             *methodName: searchEquipment
             * @Description: 按类型查找设备
               * @param equipment_type
             * @return com.util.ResponseVo
             * @author: bier
             * @date 2020/11/10 19:47
             *
             */
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "无设备信息，请重试...");
        //验证参数不为空
        if (StringUtils.isEmpty(equipment_type)){
            responseVo.setMsg("设备类型不能为空");
            return responseVo;
        }
        List<Equipment> equipment=equipmentDao.searchEquipment(equipment_type);
        if(equipment!=null){
            responseVo.setData(equipment);
            responseVo.setSuccess(true);
            responseVo.setCode(ErrorCode.SUCCESS);
            responseVo.setMsg("查询成功");
            return responseVo;
        }
        return responseVo;
    }


}
