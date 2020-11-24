package com.lbyier.equipment.dao;

import com.lbyier.equipment.model.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LByier
 * @date 2020/10/25 16:28
 */
@Repository
public interface EquipmentDao {
//    int addDate(@Param("tem") String tem, @Param("hum") String hum);



    Equipment selectEquipment(@Param("param1") String param1 ,@Param("param2") String param2,@Param("param3") String param3);

    Integer addEquipment(Equipment equipment);

    List<Equipment> selectAllEquipment(@Param("equipment_type") String equipment_type);

    List<Equipment> findEquipmentType();

    int delEquipment(@Param("equipment_type") String equipment_type,@Param("equipment_name") String equipment_name,@Param("equipment_id") String equipment_id);

    List<Equipment> searchEquipment(String equipment_type);
}
