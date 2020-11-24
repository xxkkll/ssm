package com.lbyier.equipment.service;

import com.lbyier.equipment.model.Equipment;
import com.util.ResponseVo;

/**
 * @author LByier
 * @date 2020/10/26 16:31
 */

public interface EquipmentService {
//    int addDate(String tem, String hum);




    ResponseVo addEquipment(Equipment equipment);

    ResponseVo selectAllEquipment(Equipment equipment);

    ResponseVo findEquipmentType();

    ResponseVo delEquipment(Equipment equipment);

    ResponseVo searchEquipment(String equipment_type);
}
