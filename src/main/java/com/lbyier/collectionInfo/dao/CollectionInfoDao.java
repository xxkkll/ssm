package com.lbyier.collectionInfo.dao;

import com.lbyier.collectionInfo.model.CollectionInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LByier
 * @date 2020/11/7 10:56
 */
@Repository
public interface CollectionInfoDao {
    void addData(@Param("equipment_id") String equipment_id,@Param("s") String s,@Param("s1") String s1);

    List<CollectionInfo> updateInfo();
}
