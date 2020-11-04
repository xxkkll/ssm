package com.lbyier.equipment.service.impl;

import com.lbyier.equipment.dao.EquipmentDao;
import com.lbyier.equipment.model.Equipment;
import com.lbyier.equipment.service.EquipmentService;
import com.util.ErrorCode;
import com.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author LByier
 * @date 2020/10/26 16:32
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;


    @Override
    public ResponseVo showDate() {
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL, "查询设备信息失败，请重试...");
        /*
         *methodName: showDate
         * @Description: 查询数据库的信息展示给平台
           * @param
         * @return com.util.ResponseVo
         * @author: bier
         * @date 2020/10/26 20:54
         *
         */
        Equipment equipment =equipmentDao.showDate();
        if (equipment!=null){
            responseVo.setMsg("查询设备信息成功");
            responseVo.setSuccess(true);
            responseVo.setCode(ErrorCode.SUCCESS);
            responseVo.setData(equipment);
            return responseVo;
        }
        return responseVo;
    }

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
                //查询是否有重名设备
                Equipment obj=equipmentDao.selectEquipment(equipment.getEquipment_name());
                if(obj==null){
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


}
