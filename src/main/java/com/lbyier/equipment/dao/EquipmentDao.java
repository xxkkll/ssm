package com.lbyier.equipment.dao;

import com.lbyier.equipment.model.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author LByier
 * @date 2020/10/25 16:28
 */
@Repository
public interface EquipmentDao {
//    int addDate(@Param("tem") String tem, @Param("hum") String hum);

    Equipment showDate();

    Equipment selectEquipment(String equipment_name);

    Integer addEquipment(Equipment equipment);
}
