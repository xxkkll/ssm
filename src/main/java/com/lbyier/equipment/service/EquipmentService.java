package com.lbyier.equipment.service;

import com.lbyier.equipment.model.Equipment;
import com.util.ResponseVo;

/**
 * @author LByier
 * @date 2020/10/26 16:31
 */

public interface EquipmentService {
//    int addDate(String tem, String hum);

    ResponseVo showDate();


    ResponseVo addEquipment(Equipment equipment);
}
